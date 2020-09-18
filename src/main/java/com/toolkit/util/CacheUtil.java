package com.toolkit.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存工具类
 * 
 * @author 张豪浩 zhanghaohao0820@gmail.com
 *
 */
public final class CacheUtil {

    private final static Map<String, Map<?, ?>> MAP_MAP = new ConcurrentHashMap<>();
    private final static Map<String, Set<?>> SET_MAP = new ConcurrentHashMap<>();
    private final static Map<String, List<?>> LIST_MAP = new ConcurrentHashMap<>();

    private CacheUtil() {
    }

    public static void putMap(String key, Map<?, ?> map) {
	MAP_MAP.put(key, map);
    }

    public static Map<?, ?> getMap(String key) {
	return MAP_MAP.get(key);
    }

    public static void removeMap(String key) {
	MAP_MAP.remove(key);
    }

    public static void putSet(String key, Set<?> set) {
	SET_MAP.put(key, set);
    }

    public static Set<?> getSet(String key) {
	return SET_MAP.get(key);
    }

    public static void removeSet(String key) {
	SET_MAP.remove(key);
    }

    public static void putList(String key, List<?> list) {
	LIST_MAP.put(key, list);
    }

    public static List<?> getList(String key) {
	return LIST_MAP.get(key);
    }

    public static void removeList(String key) {
	LIST_MAP.remove(key);
    }
}
