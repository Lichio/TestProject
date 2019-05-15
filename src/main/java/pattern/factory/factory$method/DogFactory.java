package pattern.factory.factory$method;

import pattern.factory.simple$factory.Animal;
import pattern.factory.simple$factory.Dog;

/**
 * TestProject pattern.factory.factory$method
 *
 * @author Lichaojie
 * @version 2019/5/14 18:16
 */
public class DogFactory extends AnimalFactory {
	@Override
	Animal create() {
		return new Dog();
	}
}
