package pattern.factory.factory$method;

import pattern.factory.simple$factory.Animal;
import pattern.factory.simple$factory.Sheep;

/**
 * TestProject pattern.factory.factory$method
 *
 * @author Lichaojie
 * @version 2019/5/14 18:17
 */
public class SheepFactory extends AnimalFactory {
	@Override
	Animal create() {
		return new Sheep();
	}
}
