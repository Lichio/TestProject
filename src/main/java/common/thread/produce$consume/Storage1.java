package common.thread.produce$consume;

import java.util.LinkedList;

/**
 * Created by Lichaojie on 2017/10/10. It's a beautiful day.
 *
 * ʹ�á�wait()��notify()����ʽʵ��������������
 */
public class Storage1 implements Storage{
    // �ֿ����洢��
    private final int MAX_SIZE = 100;

    // �ֿ�洢������
    private LinkedList<Object> list = new LinkedList<Object>();

    // ����num����Ʒ
    @Override
    public void produce(int num) {
        // ͬ�������
        synchronized (list) {
            // ����ֿ�ʣ����������
            while (list.size() + num > MAX_SIZE) {
                System.out.println("��Ҫ�����Ĳ�Ʒ������:" + num + "/t���������:"
                        + list.size() + "/t��ʱ����ִ����������!");
                try {
                    // �������������㣬��������
                    list.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // ����������������£�����num����Ʒ
            for (int i = 1; i <= num; ++i) {
                list.add(new Object());
            }

            System.out.println("���Ѿ�������Ʒ����:" + num + "/t���ֲִ���Ϊ��:" + list.size());

            list.notifyAll();
        }
    }

    // ����num����Ʒ
    @Override
    public void consume(int num) {
        // ͬ�������
        synchronized (list) {
            // ����ֿ�洢������
            while (list.size() < num) {
                System.out.println("��Ҫ���ѵĲ�Ʒ������:" + num + "/t���������:"
                        + list.size() + "/t��ʱ����ִ����������!");
                try {
                    // �������������㣬��������
                    list.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // ����������������£�����num����Ʒ
            for (int i = 1; i <= num; ++i) {
                list.remove();
            }

            System.out.println("���Ѿ����Ѳ�Ʒ����:" + num + "/t���ֲִ���Ϊ��:" + list.size());

            list.notifyAll();
        }
    }

    // get/set����
    public LinkedList<Object> getList()
    {
        return list;
    }

    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
}