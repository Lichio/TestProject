package org.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class MapTest {
    // Map

    // HashMap
    // 不保证key-value的顺序。
    // 根据key对象的hashCode通过一定的计算得到该组值的存储位置，若多组对象计算的得到相同的位置（hash冲突），采用链表方式解决
    // Node<K,V> implements Map.Entry<K,V>，利用Node数组存储键值对，相同hash值的Node以链表方式接在数组中Node的后面
    // 基于数组（Entry对象数组），速度最快。

    // TreeMap
    // SortedMap接口的实现类，TreeMap是一个红黑树结构，每个key-value作为红黑树的一个节点，确保元素处于排序状态。
    // 它可以在O(log n)时间内做查找

    public static void main(String[] args){
        //HashMap
        System.out.println("<------ HashMap ------>");
        Map<Object,Object> map = new HashMap<>(5);

        map.put("spring","春天1-3月");
        map.put("summer","夏天4-6月");
        map.put("winter", "冬天10-12月");
        map.put("fall","秋天7-9月");
        //map.put("fall","123");

        map.put(null,null);
        System.out.println(map);
        System.out.println(map.get("winter"));

        Set<Object> keySet = map.keySet();
        keySet.forEach(System.out::println);


        //LinkedHashMap保证key-value的顺序，可避免使用TreeMap增加的成本。
        //基于链
        System.out.println("<------ LinkedHashMap ------>");
        Map<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("bcd",111);
        linkedHashMap.put("abc",222);
        System.out.println(linkedHashMap);

        //TreeMap
        System.out.println("<------ TreeMap ------>");
        Map<String,String> treeMap = new TreeMap<>();
        treeMap.put("bcd","bbb");
        treeMap.put("cde","ccc");
        treeMap.put("abc", "aaa");
        System.out.println(treeMap);

        System.out.println("<------ ConcurrentHashMap ------>");
        Map concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("q","null");
        concurrentHashMap.put("qqq","ppp");
        System.out.println(concurrentHashMap);
    }
}
