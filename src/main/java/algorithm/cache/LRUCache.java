package algorithm.cache;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * TestProject algorithm.cache
 *
 * @author Lichaojie
 * @version 2018/8/13 15:09
 */

public class LRUCache {

	private int capacity;

	// 维护缓存中数据的访问顺序
	private LinkedList<String> list;

	// 存储缓存数据
	private HashMap<String, Object> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		list = new LinkedList<>();
		map = new HashMap<>();
	}

	public Object get(String key) {
		if (map.containsKey(key)) {
			list.removeFirstOccurrence(key);
			list.addFirst(key);
			return map.get(key);
		} else {
			return -1;
		}
	}

	public void put(String key, Object value) {
		if (!map.containsKey(key)) { //插入
			if (list.size() == capacity) { // 缓存满
				String last = list.removeLast();
				map.remove(last);
			}
			list.addFirst(key);
			map.put(key, value);
		} else { // 更新
			list.removeFirstOccurrence(key);
			list.addFirst(key);
			map.put(key, value);
		}
	}
}
