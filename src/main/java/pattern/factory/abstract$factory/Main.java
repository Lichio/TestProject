package pattern.factory.abstract$factory;

/**
 * TestProject pattern.factory.abstract$factory
 *
 * @author Lichaojie
 * @version 2019/5/15 11:08
 */
public class Main {
	public static void main(String[] args){
		// 系统只想获取Huawei产品族的产品
		AbstractFactory factory = new HuaweiFactory();
		Phone phone = factory.createPhone();
		phone.call();
		Computer computer = factory.createComputer();
		computer.compute();
	}
}
