package org.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class ListTest {
    // List�����Ա������������ƣ�List���Զ�̬������
    // Ԫ�����򡢿��ظ�������ÿ��Ԫ�ض������Ӧ��˳������

    // LinkedList
    // LinkedList��List�ӿڵ�ʵ���࣬��ʵ����Deque�ӿڣ����Լ��ܵ���˫�˶��У�Deque�ӿڵĹ��ܣ���ʹ�ã�Ҳ�ܵ��ɡ�ջ����List�ӿڵĹ��ܣ���ʹ�á�
    // LinkedList����nullԪ�ء�����LinkedList�ṩ�����get��remove��insert������ LinkedList���ײ���β����
    // ��Щ����ʹLinkedList�ɱ�������ջ��stack�������У�queue����˫����У�deque����

    // ArrayList
    // ÿ��ArrayListʵ������һ��������Capacity����ʼΪ10���������ڴ洢Ԫ�ص�����Ĵ�С��
    // ������������Ų��������Ԫ�ض��Զ����ӣ�Object[] elementData
    // ���������㷨��û�ж��塣����Ҫ�������Ԫ��ʱ���ڲ���ǰ���Ե���ensureCapacity����������ArrayList����������߲���Ч��
    // ���Զ����жϳ��Ⱥ�����Ҳ�ǻ��˷�ʱ��ģ���

    // ���ܱȽ�
    // ArrayList �ǻ�������ʵ�֣�����Ԫ��Ч�ʸߣ������롢ɾ��Ч�ʵ�
    // LinkedList�ǻ�������ʵ�֣�����Ԫ��Ч�ʵͣ������롢ɾ��Ч�ʸ�

    // ����ж���߳���Ҫͬʱ����List�����е�Ԫ�أ�������Collections�����ϰ�װ���̰߳�ȫ�ļ��ϡ�

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
