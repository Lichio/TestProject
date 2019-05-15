package pattern.factory.simple$factory;

/**
 * TestProject pattern.factory.simple$factory
 *
 * @author Lichaojie
 * @version 2019/5/14 16:46
 */
public class Main {
	public static void main(String[] args){
		Animal cat = AnimalFactory.createAnimal("cat");
		cat.sing();

		Animal dog = AnimalFactory.createAnimal("dog");
		dog.sing();

		Animal sheep = AnimalFactory.createAnimal("sheep");
		sheep.sing();

	}
}
