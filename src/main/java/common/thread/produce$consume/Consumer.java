package common.thread.produce$consume;

/**
 * Created by Lichaojie on 2017/10/10. It's a beautiful day.
 */
public class Consumer extends Thread {
    // ÿ�����ѵĲ�Ʒ����
    private int num;

    // ���ڷ��õĲֿ�
    private Storage storage;

    // ���캯�������òֿ�
    public Consumer(Storage storage)
    {
        this.storage = storage;
    }

    // �߳�run����
    @Override
    public void run()
    {
        consume(num);
    }

    // ���òֿ�Storage����������
    public void consume(int num)
    {
        storage.consume(num);
    }

    // get/set����
    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public Storage getStorage()
    {
        return storage;
    }

    public void setStorage(Storage storage)
    {
        this.storage = storage;
    }
}
