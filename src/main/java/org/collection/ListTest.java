package org.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class ListTest {
    // List（线性表）：和数组类似，List可以动态增长，
    // 元素有序、可重复，其中每个元素都有其对应的顺序索引

    // LinkedList
    // LinkedList是List接口的实现类，还实现了Deque接口，所以既能当成双端队列（Deque接口的功能）来使用，也能当成“栈”（List接口的功能）来使用。
    // LinkedList允许null元素。此外LinkedList提供额外的get，remove，insert方法在 LinkedList的首部或尾部。
    // 这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）。

    // ArrayList
    // 每个ArrayList实例都有一个容量（Capacity，初始为10），即用于存储元素的数组的大小。
    // 这个容量可随着不断添加新元素而自动增加，Object[] elementData
    // 但是增长算法并没有定义。当需要插入大量元素时，在插入前可以调用ensureCapacity方法来增加ArrayList的容量以提高插入效率
    // （自动增判断长度后增长也是会浪费时间的）。

    // 性能比较
    // ArrayList 是基于数组实现，访问元素效率高，但插入、删除效率低
    // LinkedList是基于链表实现，访问元素效率低，但插入、删除效率高

    // 如果有多个线程需要同时访问List集合中的元素，可以用Collections将集合包装成线程安全的集合。

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("cde");
        list.add("bcd");
        for(String str : list){
            System.out.println(str);
        }

        list.forEach( s -> System.out.println(">>> : " + s));

        list.add("abc");
        System.out.println("index : " + list.indexOf("abc"));
    }
}
