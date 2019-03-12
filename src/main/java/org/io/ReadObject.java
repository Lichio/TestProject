package org.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by LiChaojie on 2016/3/11.
 */

//使用序列化机制向文件中写入多个Java对象，使用反序列化机制恢复对象时必须按照写入的顺序读取。
//当程序序列化一个可变对象时，只有第一次使用writeObject()方法输出时才会将该对象转化成字符序列并输出，
//当程序再次调用writeObject()方法时，程序只是输出前面的序列化编号，即使后面该对象的实例变量值已经改变，
//改变的实例变量值也不会被输出。
public class ReadObject {
    public static void main(String[] args){
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\Java\\Code\\object.txt"));
            Person person = (Person)objectInputStream.readObject();
            System.out.println("name:" + person.getName() + "\nage:" + person.getAge());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
