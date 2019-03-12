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

//���������л���ʵ�ֿ����л��ӿڣ������ܽ�Java����д��I/O����
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

    //ʹ��transient���Σ�Java���л�ʱ����Դ˱�����
    private transient String name;
    private int age;

    //����˱�������ʶ��Java������л��汾������ֹ��Ŀ����ʱ .class�ļ����������·����л����ɹ���
    private static final long serialVersionUID = 520L;
}