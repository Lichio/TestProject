package pattern.factory.factory$method;

import pattern.factory.simple$factory.Animal;
import pattern.factory.simple$factory.Cat;

/**
 * TestProject pattern.factory.factory$method
 *
 * @author Lichaojie
 * @version 2019/5/14 18:15
 */
public class CatFactory extends AnimalFactory {
	@Override
	Animal create() {
		return new Cat();
	}
}
