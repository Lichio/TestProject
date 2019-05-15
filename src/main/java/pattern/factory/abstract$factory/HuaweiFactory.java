package pattern.factory.abstract$factory;

/**
 * TestProject pattern.factory.abstract$factory
 *
 * @author Lichaojie
 * @version 2019/5/15 11:06
 */
public class HuaweiFactory implements AbstractFactory {
	@Override
	public Phone createPhone() {
		return new HuaweiPhone();
	}

	@Override
	public Computer createComputer() {
		return new HuaweiComputer();
	}
}
