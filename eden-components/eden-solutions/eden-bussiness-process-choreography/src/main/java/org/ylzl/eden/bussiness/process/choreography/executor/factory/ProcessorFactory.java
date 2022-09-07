package org.ylzl.eden.bussiness.process.choreography.executor.factory;

import org.ylzl.eden.bussiness.process.choreography.executor.Processor;

/**
 * 流程执行器实例化抽象工厂
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public interface ProcessorFactory {

	/**
	 * 实例化
	 *
	 * @param className   类名
	 * @param processName 名称
	 * @return
	 * @throws Exception
	 */
	Processor newInstance(String className, String processName) throws Exception;
}