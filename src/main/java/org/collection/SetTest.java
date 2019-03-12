package org.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class SetTest {
    // Set������Collection��ȫһ���Ľӿڣ����û���κζ���Ĺ��ܣ�ʵ����Set����Collection,ֻ����Ϊ��ͬ��
    // Ԫ�����򡢲����ظ���

    // HashSet
    // ���ظ�Ԫ�أ���Ԫ�ص�HashCodeֵ��ͬ����equals��������ֵΪtrueʱ ��ʾ��Ԫ����ͬ��
    // ����֤˳��˳����������˳��ͬ��
    // HashSet�����Ԫ�ص�HashCodeֵ������Ԫ�صĴ洢λ��
    // Ԫ�ؿ���Ϊ null
    // ���� HashMap ʵ�֣�ֵ�����HashMap��ֵ�Եļ�λ���ϣ����Ӧ��ֵλ�÷�һ���յĶ���

    // LinkedHashSet
    // HashSet�����࣬������ά�����򣬱���ʱ�����˳�����

    // TreeSet
    // SortedSet�ӿڵ�ʵ���࣬ȷ��Ԫ�ش�������״̬��(��ϣ��TreeSet��������������ֻ�����ͬһ�����͵�Ԫ�ء�)
    // ���ڽ�����Ԫ����ӵ�������ʱ���Զ�����ĳ�ֱȽϹ�������뵽����Ķ���������
    // ����TreeMapʵ��

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
        System.out.println("С��bcd�����Ԫ��:" + s3.lower("bcd"));
        System.out.println("����bcd����СԪ��:" + s3.higher("bcd"));
    }
}
