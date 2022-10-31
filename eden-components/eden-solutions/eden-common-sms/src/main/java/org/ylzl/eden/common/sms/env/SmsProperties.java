package org.ylzl.eden.common.sms.env;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.ylzl.eden.common.sms.core.SmsType;

/**
 * 短信配置
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@Data
@ConfigurationProperties(prefix = SmsProperties.PREFIX)
public class SmsProperties {

	public static final String PREFIX = "sms";

	public static final String ENABLED = PREFIX + ".enabled";

	private SmsType type;
}