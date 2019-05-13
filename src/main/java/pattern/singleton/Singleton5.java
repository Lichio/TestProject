package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 17:09
 *
 * ��̬�ڲ��ࣨ�̰߳�ȫ���ӳٳ�ʼ����
 * �̰߳�ȫ��INSTANCE����ֻ��SingletonHolder����ع�����ʵ����һ��
 * �ӳٳ�ʼ�����ڵ���pattern.singleton.Singleton5#getInstance()����ʱ��ʹ��SingletonHolder��INSTANCE��������ʱ�Ż���ʽ����SingletonHolder�࣬�Ӷ�ʵ�����������INSTANCE
 */
public class Singleton5 {
	private static class SingletonHolder{
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	private Singleton5(){}
	public static Singleton5 getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
