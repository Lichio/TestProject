package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 16:27
 *
 * 懒汉式（非线程安全，延迟初始化）
 *
 * 非线程安全，在多线程下并不能实现单例
 */
public class Singleton1 {
	private static Singleton1 instance;
	private Singleton1 (){}

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}

