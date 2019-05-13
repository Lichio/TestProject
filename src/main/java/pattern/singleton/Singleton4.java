package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 17:00
 *
 * DCL（线程安全，延迟初始化）
 *
 * 通过volatile关键字保证类变量的可见性，
 * 只有在未初始化之前，第一批请求实例的线程才会进入同步块，且最终只有一个线程完成初始化操作（第二道检查起作用）
 * 如果已经存在初始化的实例，之后的线程都不会进入同步块（第一道检查起作用）
 */
public class Singleton4 {
	private static volatile Singleton4 instance;
	private Singleton4(){}

	public static Singleton4 getInstance(){
		if(null == instance){ // 第一道检查
			synchronized (Singleton4.class){
				if( null == instance){ // 第二道检查
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}
}
