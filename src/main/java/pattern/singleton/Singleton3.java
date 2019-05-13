package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 16:59
 *
 * ����ʽ���̰߳�ȫ�����ӳٳ�ʼ����
 *
 * ����ؽ׶ξͳ�ʼ�����󣬻���ǰռ���ڴ�
 * ��ǰ��ʼ�����󣬱�����߳��´��������ͬ�����⣬pattern.singleton.Singleton3#getInstance()����Ч�����
 */
public class Singleton3 {
	private static Singleton3 instance = new Singleton3();
	private Singleton3(){}

	public static Singleton3 getInstance(){
		return instance;
	}
}
