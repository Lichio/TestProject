package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 16:33
 *
 * 懒汉式（线程安全，延迟初始化）
 *
 * 延迟初始化，避免内存浪费
 * 使用同步方式保证线程安全，如果pattern.singleton.Singleton2#getInstance()方法使用频繁将会影响程序性能
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
