package org.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by LiChaojie on 2016/3/11.
 */
public class WriteObject {
    public static void main(String[] args){
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\Java\\Code\\object.txt"));
            Person person = new Person("Kristy",23);
            objectOutputStream.writeObject(person);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}

//将对象序列化（实现可序列化接口），就能将Java对象写入I/O流。
class Person implements Serializable{
    public Person() {
        this.name = "Li Chaojie";
        this.age = 24;
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //使用transient修饰，Java序列化时会忽略此变量。
    private transient String name;
    private int age;

    //定义此变量（标识该Java类的序列化版本），防止项目升级时 .class文件升级，导致反序列化不成功。
    private static final long serialVersionUID = 520L;
}