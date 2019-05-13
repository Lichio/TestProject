package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 16:33
 *
 * ����ʽ���̰߳�ȫ���ӳٳ�ʼ����
 *
 * �ӳٳ�ʼ���������ڴ��˷�
 * ʹ��ͬ����ʽ��֤�̰߳�ȫ�����pattern.singleton.Singleton2#getInstance()����ʹ��Ƶ������Ӱ���������
 */
public class Singleton2 {
	private static Singleton2 instance;
	private Singleton2 (){}

	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}
