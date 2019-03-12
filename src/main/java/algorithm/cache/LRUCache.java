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

	// ά�����������ݵķ���˳��
	private LinkedList<String> list;

	// �洢��������
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
		if (!map.containsKey(key)) { //����
			if (list.size() == capacity) { // ������
				String last = list.removeLast();
				map.remove(last);
			}
			list.addFirst(key);
			map.put(key, value);
		} else { // ����
			list.removeFirstOccurrence(key);
			list.addFirst(key);
			map.put(key, value);
		}
	}
}
