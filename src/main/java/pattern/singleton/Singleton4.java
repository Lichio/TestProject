package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 17:00
 *
 * DCL���̰߳�ȫ���ӳٳ�ʼ����
 *
 * ͨ��volatile�ؼ��ֱ�֤������Ŀɼ��ԣ�
 * ֻ����δ��ʼ��֮ǰ����һ������ʵ�����̲߳Ż����ͬ���飬������ֻ��һ���߳���ɳ�ʼ���������ڶ�����������ã�
 * ����Ѿ����ڳ�ʼ����ʵ����֮����̶߳��������ͬ���飨��һ����������ã�
 */
public class Singleton4 {
	private static volatile Singleton4 instance;
	private Singleton4(){}

	public static Singleton4 getInstance(){
		if(null == instance){ // ��һ�����
			synchronized (Singleton4.class){
				if( null == instance){ // �ڶ������
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}
