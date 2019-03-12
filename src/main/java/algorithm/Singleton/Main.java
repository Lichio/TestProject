package algorithm.Singleton;

/**
 * TestProject algorithm.Singleton
 *
 * @author Lichaojie
 * @version 2018/8/10 17:16
 */
public class Main {

}

/**
 * 懒汉式（非线程安全，延迟初始化）
 */
class Singleton1 {
	private static Singleton1 instance;
	private Singleton1 (){}

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}

/**
 * 懒汉式（线程安全，延迟初始化）
 */
class Singleton2 {
	private static Singleton2 instance;
	private Singleton2 (){}

	public static synchronized Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

/**
 * 饿汉式（线程安全，非延迟初始化）
 */
class Singleton3 {
	private static Singleton3 instance = new Singleton3();
	private Singleton3(){}

	public static Singleton3 getInstance(){
		return instance;
	}
}


/**
 * DCL
 */
class Singleton4 {
	private static volatile Singleton4 instance;
	private Singleton4(){}

	public static Singleton4 getInstance(){
		if(null == instance){
			synchronized (Singleton4.class){
				if( null == instance){
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}

/**
 * 静态内部类方式
 */
class Singleton5 {
	private static class SingletonHolder{
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	private Singleton5(){}
	public static Singleton5 getInstance(){
		return SingletonHolder.INSTANCE;
	}
}

/**
 * 枚举方式
 */
enum Singleton6{
	INSTANCE;
	Singleton6(){}
}