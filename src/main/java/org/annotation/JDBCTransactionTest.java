package org.annotation;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class JDBCTransactionTest {
    public static void main(String[] args){
        System.out.println("This program do nothing without recording something!");
    }
}

//JDBC������֧����Connection�ṩ��ConnectionĬ�ϴ��Զ��ύ�����ر�����������ÿһ��SQLһִ�У��ͻ��ύ�����ݿ⣬������Ч�����ܻع���
//����Connection��setAutoCommit()���������Զ��ύ�رգ������ʹ�������
//����֮���SQL�����Ȼִ���ˣ����������浽���ݿ⣬ֻ�е���Connection��commit()�����ύ���ܱ��浽���ݿ⣬���ύǰ�ܹ��ع���
