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

package org.ylzl.eden.spring.framework.web.rest.vm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 字段错误视图模型
 *
 * @author gyl
 * @since 2.4.x
 */
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@ApiModel(description = "字段错误视图模型")
public class FieldErrorVM extends ErrorVM {

	private List<FieldError> fieldErrors;

	public void add(String objectName, String field, String message) {
		if (fieldErrors == null) {
			fieldErrors = new ArrayList<>();
		}
		fieldErrors.add(
			FieldError.builder().objectName(objectName).field(field).message(message).build());
	}

	@SuperBuilder(toBuilder = true)
	@Data
	@EqualsAndHashCode
	@ToString
	public static class FieldError {

		@ApiModelProperty(value = "对象名称")
		private String objectName;

		@ApiModelProperty(value = "字段")
		private String field;

		@ApiModelProperty(value = "消息")
		private String message;
	}
}
