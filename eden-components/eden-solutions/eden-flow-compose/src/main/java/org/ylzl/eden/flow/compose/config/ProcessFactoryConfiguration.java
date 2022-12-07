package org.ylzl.eden.flow.compose.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ylzl.eden.flow.compose.processor.SpringBeanProcessorFactory;

/**
 * Spring Bean 注入流程处理器自动装配
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class ProcessFactoryConfiguration {

	public static final String SPRING_BEAN_PROCESSOR_FACTORY_NAME = "springBeanProcessorFactory";

	private static final String AUTOWIRED_SPRING_BEAN_PROCESSOR_FACTORY = "Autowired SpringBeanProcessorFactory";

	@Bean
	public SpringBeanProcessorFactory springBeanProcessorFactory() {
		log.debug(AUTOWIRED_SPRING_BEAN_PROCESSOR_FACTORY);
		return new SpringBeanProcessorFactory();
	}
}
