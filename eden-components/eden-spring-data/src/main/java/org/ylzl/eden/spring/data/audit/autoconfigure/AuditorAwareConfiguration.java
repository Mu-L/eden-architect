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

package org.ylzl.eden.spring.data.audit.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.ylzl.eden.spring.data.audit.domain.AuthorizedAuditorAware;

/**
 * AuditorAware 自动配置
 *
 * @author gyl
 * @since 2.4.x
 */
@EnableJpaAuditing(auditorAwareRef = AuditorAwareConfiguration.BEAN_NAME)
@Configuration
public class AuditorAwareConfiguration {

	public static final String BEAN_NAME = "authorizedAuditorAware";

	@ConditionalOnMissingBean
	@Bean(BEAN_NAME)
	public AuthorizedAuditorAware authorizedAuditorAware() {
		return new AuthorizedAuditorAware();
	}
}