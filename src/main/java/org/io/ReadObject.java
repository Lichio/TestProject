package org.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by LiChaojie on 2016/3/11.
 */

//ʹ�����л��������ļ���д����Java����ʹ�÷����л����ƻָ�����ʱ���밴��д���˳���ȡ��
//���������л�һ���ɱ����ʱ��ֻ�е�һ��ʹ��writeObject()�������ʱ�ŻὫ�ö���ת�����ַ����в������
//�������ٴε���writeObject()����ʱ������ֻ�����ǰ������л���ţ���ʹ����ö����ʵ������ֵ�Ѿ��ı䣬
//�ı��ʵ������ֵҲ���ᱻ�����
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
