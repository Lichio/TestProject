package pattern.factory.abstract$factory;

/**
 * TestProject pattern.factory.abstract$factory
 *
 * @author Lichaojie
 * @version 2019/5/15 10:53
 */
public class HuaweiPhone implements Phone {
	@Override
	public void call() {
		System.out.println("Huawei Phone call.");
	}
}
