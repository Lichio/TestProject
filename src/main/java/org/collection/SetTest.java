package org.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class SetTest {
    // Set具有与Collection完全一样的接口，因此没有任何额外的功能，实际上Set就是Collection,只是行为不同。
    // 元素无序、不可重复，

    // HashSet
    // 无重复元素（两元素的HashCode值相同，且equals方法返回值为true时 表示两元素相同）
    // 不保证顺序（顺序可能与添加顺序不同）
    // HashSet会根据元素的HashCode值来计算元素的存储位置
    // 元素可以为 null
    // 基于 HashMap 实现，值存放在HashMap键值对的键位置上，相对应的值位置放一个空的对象，

    // LinkedHashSet
    // HashSet的子类，用链表维护次序，遍历时按添加顺序访问

    // TreeSet
    // SortedSet接口的实现类，确保元素处于排序状态。(若希望TreeSet能正常工作，则只能添加同一种类型的元素。)
    // 它在将对象元素添加到集合中时会自动按照某种比较规则将其插入到有序的对象序列中
    // 基于TreeMap实现

    public static void main(String[] args){
        //HashSet
        Set<Object> s1 = new HashSet<>();
        s1.add("abc");
        s1.add("abc");
        s1.add("bcd");
        System.out.println(s1);

        //LinkedHashSet
        Set<Object> s2 = new LinkedHashSet<>();
        s2.add("abc");
        s2.add("cde");
        s2.add("bcd");
        System.out.println(s2);

        //TreeSet
        TreeSet<Object> s3 = new TreeSet<>();
        s3.add("cde");
        s3.add("abc");
        s3.add("bcd");
        System.out.println(s3);
        System.out.println("first element:" + s3.first());
        System.out.println("last element:" + s3.last());
        System.out.println("小于bcd的最大元素:" + s3.lower("bcd"));
        System.out.println("大于bcd的最小元素:" + s3.higher("bcd"));
    }
}
