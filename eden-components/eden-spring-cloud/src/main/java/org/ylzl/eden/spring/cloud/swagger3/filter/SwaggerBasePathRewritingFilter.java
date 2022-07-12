/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.spring.cloud.swagger3.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter;
import org.ylzl.eden.commons.io.IOUtils;
import org.ylzl.eden.commons.lang.StringConstants;
import org.ylzl.eden.commons.lang.StringUtils;
import org.ylzl.eden.spring.cloud.zuul.constant.ZuulConstants;
import org.ylzl.eden.spring.framework.bootstrap.constant.GlobalConstants;
import springfox.documentation.swagger2.web.Swagger2Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.zip.GZIPInputStream;

/**
 * Swagger Base Path 过滤器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Slf4j
public class SwaggerBasePathRewritingFilter extends SendResponseFilter {

	private ObjectMapper mapper = new ObjectMapper();

	public SwaggerBasePathRewritingFilter() {
		super();
	}

	@Override
	public String filterType() {
		return ZuulConstants.FILTER_TYPE_POST;
	}

	@Override
	public int filterOrder() {
		return 100;
	}

	@Override
	public boolean shouldFilter() {
		return RequestContext.getCurrentContext()
			.getRequest()
			.getRequestURI()
			.endsWith(Swagger2Controller.DEFAULT_URL);
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		if (!context.getResponseGZipped()) {
			context.getResponse().setCharacterEncoding(GlobalConstants.DEFAULT_ENCODING);
		}
		String rewrittenResponse = rewriteBasePath(context);
		if (rewrittenResponse != null) {
			context.setResponseBody(rewrittenResponse);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private String rewriteBasePath(RequestContext context) {
		InputStream responseDataStream = context.getResponseDataStream();
		String requestUri = RequestContext.getCurrentContext().getRequest().getRequestURI();
		try {
			if (context.getResponseGZipped()) {
				responseDataStream = new GZIPInputStream(context.getResponseDataStream());
			}
			String response =
				IOUtils.toString(responseDataStream, GlobalConstants.DEFAULT_ENCODING);
			if (StringUtils.isNotBlank(response)) {
				LinkedHashMap<String, Object> map = this.mapper.readValue(response, LinkedHashMap.class);
				String basePath = requestUri.replace(Swagger2Controller.DEFAULT_URL, StringConstants.EMPTY);
				map.put("basePath", basePath);
				return mapper.writeValueAsString(map);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
}