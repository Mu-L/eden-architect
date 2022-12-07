package org.ylzl.eden.flow.compose.exception;

import org.ylzl.eden.spring.framework.error.BaseException;

/**
 * 流程配置无效异常
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public class ProcessConfigException extends BaseException {

	public ProcessConfigException(String errMessage) {
		super("SYS-ERROR-500", errMessage);
	}

	public ProcessConfigException(String errMessage, Throwable e) {
		super("SYS-ERROR-500", errMessage, e);
	}
}
