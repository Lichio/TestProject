package pattern.factory.abstract$factory;

/**
 * TestProject pattern.factory.abstract$factory
 *
 * @author Lichaojie
 * @version 2019/5/15 11:08
 */
public class Main {
	public static void main(String[] args){
		// ϵͳֻ���ȡHuawei��Ʒ��Ĳ�Ʒ
		AbstractFactory factory = new HuaweiFactory();
		Phone phone = factory.createPhone();
		phone.call();
		Computer computer = factory.createComputer();
		computer.compute();
	}
}
