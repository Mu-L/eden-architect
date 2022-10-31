package org.ylzl.eden.common.cache.integration.hotkey.sentinel.core;

import org.ylzl.eden.common.cache.core.hotkey.HotKey;

import java.util.function.Function;

/**
 * Sentinel热key探测
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class SentinelHotKey implements HotKey {

	@Override
	public <K> boolean isHotKey(K key, Function<K, Object> builder) {
		return false;
	}
}