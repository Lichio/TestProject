package pattern.factory.abstract$factory;

/**
 * TestProject pattern.factory.abstract$factory
 *
 * @author Lichaojie
 * @version 2019/5/15 11:07
 */
public class AppleFactory implements AbstractFactory {
	@Override
	public Phone createPhone() {
		return new ApplePhone();
	}

	@Override
	public Computer createComputer() {
		return new AppleComputer();
	}
}
