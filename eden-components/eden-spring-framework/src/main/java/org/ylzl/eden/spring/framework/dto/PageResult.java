/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.spring.framework.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 分页结果
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class PageResult<T> extends Result {

	private Collection<T> data;

	private int totalCount = 0;

	public Collection<T> getData() {
		if (data == null) {
			return Collections.emptyList();
		}
		if (data instanceof List) {
			return data;
		}
		return new ArrayList<>(data);
	}

	public static <T> PageResult<T> build(Collection<T> data, int totalCount) {
		PageResult<T> result = new PageResult<>();
		result.setSuccess(true);
		result.setData(data);
		result.setTotalCount(totalCount);
		return result;
	}
}