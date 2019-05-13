package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 16:59
 *
 * 饿汉式（线程安全，非延迟初始化）
 *
 * 类加载阶段就初始化对象，会提前占用内存
 * 提前初始化对象，避免多线程下创建对象的同步问题，pattern.singleton.Singleton3#getInstance()方法效率提高
 */
public class Singleton3 {
	private static Singleton3 instance = new Singleton3();
	private Singleton3(){}

	public static Singleton3 getInstance(){
		return instance;
	}
}
