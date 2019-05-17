package pattern.decorator;

/**
 * TestProject pattern.decorator
 *
 * @author Lichaojie
 * @version 2019/5/17 11:54
 */
public class Main {
	public static void main(String[] args){
		SpiderMan spiderMan = new SpiderMan(new Peter());
		spiderMan.run();
		spiderMan.absorb();

		Batman batman = new Batman(new Bruce());
		batman.run();
		batman.fly();
	}
}
