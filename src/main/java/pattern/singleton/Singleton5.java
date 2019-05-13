package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 17:09
 *
 * 静态内部类（线程安全，延迟初始化）
 * 线程安全：INSTANCE变量只在SingletonHolder类加载过程中实例化一次
 * 延迟初始化：在调用pattern.singleton.Singleton5#getInstance()方法时会使用SingletonHolder的INSTANCE变量，此时才会显式加载SingletonHolder类，从而实例化其类变量INSTANCE
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
