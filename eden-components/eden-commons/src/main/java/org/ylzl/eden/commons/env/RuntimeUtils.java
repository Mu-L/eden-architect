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
package org.ylzl.eden.commons.env;

import lombok.experimental.UtilityClass;

import java.lang.management.ManagementFactory;

/**
 * 运行工具集
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@UtilityClass
public class RuntimeUtils {

	/**
	 * 获取进程 ID
	 *
	 * @return PID
	 */
	public static long getPID() {
		try {
			String jvmName = ManagementFactory.getRuntimeMXBean().getName();
			int index = jvmName.indexOf('@');
			if (index > 0) {
				return Long.parseLong(jvmName.substring(0, index));
			}
		} catch (Throwable e) {
			// ignore
		}
		return -1;
	}
}
