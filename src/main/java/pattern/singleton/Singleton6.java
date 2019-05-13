package pattern.singleton;

/**
 * TestProject pattern.singleton
 *
 * @author Lichaojie
 * @version 2019/5/13 17:15
 *
 * 枚举（线程安全，非延迟初始化）
 * 枚举类型在编译之后会生成一个继承自java.lang.Enum的类，枚举变量会变成类变量，且在静态代码块中进行初始化操作
 */
enum  Singleton6 {
	INSTANCE;
	Singleton6(){}
}
