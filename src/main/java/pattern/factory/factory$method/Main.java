package pattern.factory.factory$method;

import pattern.factory.simple$factory.Animal;
import pattern.factory.simple$factory.Cat;

/**
 * TestProject pattern.factory.factory$method
 *
 * @author Lichaojie
 * @version 2019/5/14 18:17
 */
public class Main {
	public static void main(String[] args){
		AnimalFactory catFactory = new CatFactory();
		Animal cat = catFactory.create();
		cat.sing();

		AnimalFactory dogFactory = new DogFactory();
		Animal dog = dogFactory.create();
		dog.sing();

		AnimalFactory sheepFactory = new SheepFactory();
		Animal sheep = sheepFactory.create();
		sheep.sing();
	}
}
