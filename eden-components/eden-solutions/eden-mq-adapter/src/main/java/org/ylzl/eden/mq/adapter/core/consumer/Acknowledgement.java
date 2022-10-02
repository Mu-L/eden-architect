package org.ylzl.eden.mq.adapter.core.consumer;

/**
 * ACK 确认
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@FunctionalInterface
public interface Acknowledgement {

	/**
	 * 提交
	 */
	void acknowledge();
}
