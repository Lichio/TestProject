package pattern.factory.simple$factory;

import javax.crypto.KeyGenerator;
import java.text.DateFormat;

/**
 * TestProject pattern.factory.simple$factory
 *
 * @author Lichaojie
 * @version 2019/5/14 16:41
 */
public class AnimalFactory {
	public static Animal createAnimal(String animalName){
		if ("cat".equals(animalName)){
			return new Cat();
		}else if ("dog".equals(animalName)){
			return new Dog();
		}else if ("sheep".equals(animalName)){
			return new Sheep();
		}else {
			return null;
		}
	}
}
