package org.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class IteratorTest {
    public static void main(String[] args){
        Collection<Object> collection = new HashSet<>();
        collection.add("Hello World!");
        collection.add("crazy boy.");
        collection.add(12345);
        System.out.println("ʹ��ForEachѭ��:");
        for(Object object : collection){
            System.out.println(object);
        }
        System.out.println(collection);

        System.out.println("\nʹ��Iterator������:");
        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator.remove();
        System.out.println(collection);
    }
}
