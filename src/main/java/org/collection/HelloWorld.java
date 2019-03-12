package org.collection;


import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Created by LiChaojie on 2016/2/29.
 */
public class HelloWorld {
    public static void test() throws Exception{

        System.out.println("Hello world!\nI'm Li Chaojie");
        System.out.println();

        String ���� = "���";//��Ϊjava�ڲ�������unicode�ģ�����java��ʵ��֧�����ı�������
        char �Ա� = '��';//java��char�������ֽڣ��������ַ�Ҳ�������ֽ�
        System.out.println("������" + ���� + ",\n" + "�Ա�" + �Ա�);

        String string = "";
        String[] list = string.split(",");


        System.out.println("ռ���ڴ��С:" + "{1,0,1,0,0}".getBytes().length);

        System.out.println(System.currentTimeMillis());

        sleep(1000);

        int count = 0;
        for (int i = 0 ; i <= 100; i ++){
            count = count ++;
        }
        System.out.println("count : " + count);
    }




    public static void main(String[] args) throws Exception{
        //test();

        //String s1 = "abc";
        String s2 = new String("ab") + "c";
        String s = s2.intern();
        String s3 = "abc";

        //System.out.println("s1 : " + s1.hashCode());
        System.out.println("s2 : " + s2.hashCode());
        System.out.println(s2==s3);
        System.out.println(s2.intern()==s3);

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(9);
        threadLocal.set(8);
        System.out.println("threadLocal : " + threadLocal.get());
        threadLocal.remove();
        System.out.println("threadLocal : " + threadLocal.get());

        Byte b;
        Short sh;
        Integer integer;
        Long lo;
        Character character;
        Boolean ds;
        Float dff;
        System.out.println("char : " + (char)126);
        System.out.println(Byte.BYTES);
        System.out.println(Short.BYTES);
        System.out.println(Integer.BYTES);
        System.out.println(Long.BYTES);
        System.out.println(Character.BYTES);
        System.out.println(Character.TYPE);

        new Test();

        ByteBuffer.allocateDirect(1024);
        System.gc();

        ArrayList<String> arrayList = new ArrayList<>();
        String string = "I love programming";
        int left = 0;
        int right = 0;
        while (true){
            right = string.indexOf(" ",left);
            if(right == -1) break;
            arrayList.add(string.substring(left,right));
            left = right + 1;
        }
        arrayList.add(string.substring(left,string.length()));
        arrayList.forEach(n -> System.out.print(n + " "));

        test1();
        System.out.println("hashCode : " + new Object().hashCode());


		BigInteger integer1 = new BigInteger("12345678887654321");
		BigInteger integer2 = new BigInteger("11111111111111111");
		BigInteger integer3 = integer1.multiply(integer2);
		System.out.println(integer3);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {

			}
		});




    }


    //����
    public static void test1(){
    	Integer a = 1;
    	Integer b = 2;

    	System.out.println("\nbefore : a=" + a + ",b=" + b);
		swap(a,b);
		System.out.println("after : a=" + a + ",b=" + b);

		//ʹ�÷����޸�String��ֵ
		String s = "Hello World!";
		try {
			System.out.println("s >> :" + System.identityHashCode(s));
			Field field = String.class.getDeclaredField("value");
			field.setAccessible(true);
			char[] array = (char[])field.get(s);
			Array.set(array,0,'c');
			System.out.println("s : " + s);
			System.out.println("s >> :" + System.identityHashCode(s));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void swap(Integer a,Integer b){
    	try {
			Field field = Integer.class.getDeclaredField("value");
			field.setAccessible(true);
			int t = b;
			field.setInt(b,a);
			field.setInt(a,t);
		}catch (Exception e){

		}
	}

    static class NestedClass1 implements Runnable{

        @Override
        public void run(){
        	System.out.println("NestedClass1 !");
		}
    }

}

class Sample
{
    Sample(String s)
    {
        System.out.println(s);
    }
    Sample()
    {
        System.out.println("SampleĬ�Ϲ��캯��������");
    }
}
class Test {
    static {
        System.out.println("static��ִ��");
        //if (sam == null) System.out.println("sam is null");
        Sample sam = new Sample("��̬���ڳ�ʼ��sam��Ա����");
    }
    static Sample sam = new Sample("��̬��Աsam��ʼ��");
    Sample sam1 = new Sample("sam1��Ա��ʼ��");



    Test() {
        System.out.println("TestĬ�Ϲ��캯��������");
    }
}

class NestedClass implements Cloneable{
    public int number = 12;

    public NestedClass setNumber(int number){
        this.number = number;
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}