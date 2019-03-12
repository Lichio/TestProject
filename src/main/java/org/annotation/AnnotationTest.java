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
        System.out.println("水果的info()方法......");
    }
}

class Apple extends Fruit{
    @Override
    //@Override保证父类有一个被该方法重写的方法。
    public void info(){
        System.out.println("苹果重写水果的info()方法......");
    }

    @Deprecated
    //@Deprecated表示该方法已过时，当程序使用已过时方法时系统会给出警告。
    public void print(){
        System.out.println("苹果的已过时方法......");
    }

    @SuppressWarnings(value="unchecked")
    //抑制警告
    public void warning(){
        List<String> list = new ArrayList();
        System.out.println("Doing nothing......");
    }
}