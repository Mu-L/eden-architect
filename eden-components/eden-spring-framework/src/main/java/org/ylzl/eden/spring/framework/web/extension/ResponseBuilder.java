package org.ylzl.eden.spring.framework.web.extension;

import org.jetbrains.annotations.PropertyKey;
import org.ylzl.eden.extension.ExtensionLoader;
import org.ylzl.eden.extension.SPI;
import org.ylzl.eden.spring.framework.error.ErrorCodeLoader;

/**
 * 响应结果构建
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@SPI("default")
public interface ResponseBuilder<T> {

	static ResponseBuilder<?> builder() {
		return ExtensionLoader.getExtensionLoader(ResponseBuilder.class).getDefaultExtension();
	}

	T buildSuccess();

	<Body> T buildSuccess(Body data);

	T buildFailure(@PropertyKey(resourceBundle = ErrorCodeLoader.BUNDLE_NAME) String errCode,
				   Object... params);

	T buildFailure(@PropertyKey(resourceBundle = ErrorCodeLoader.BUNDLE_NAME) String errCode,
				   String errMessage, Object... params);
}
