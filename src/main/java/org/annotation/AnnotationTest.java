package org.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class AnnotationTest {
    public static void main(String[] args){

    }
}

class Fruit{
    public void info(){
        System.out.println("ˮ����info()����......");
    }
}

class Apple extends Fruit{
    @Override
    //@Override��֤������һ�����÷�����д�ķ�����
    public void info(){
        System.out.println("ƻ����дˮ����info()����......");
    }

    @Deprecated
    //@Deprecated��ʾ�÷����ѹ�ʱ��������ʹ���ѹ�ʱ����ʱϵͳ��������档
    public void print(){
        System.out.println("ƻ�����ѹ�ʱ����......");
    }

    @SuppressWarnings(value="unchecked")
    //���ƾ���
    public void warning(){
        List<String> list = new ArrayList();
        System.out.println("Doing nothing......");
    }
}