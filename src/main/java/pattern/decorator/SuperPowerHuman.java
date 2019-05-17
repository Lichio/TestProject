package pattern.decorator;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * TestProject pattern.decorator
 *
 * @author Lichaojie
 * @version 2019/5/17 11:34
 */
public abstract class SuperPowerHuman extends Human{
	private Human human;

	public SuperPowerHuman(Human human){
		this.human = human;
	}

	@Override
	public void run() {
		human.run();
	}
}
