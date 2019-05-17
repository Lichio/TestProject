package pattern.decorator;

/**
 * TestProject pattern.decorator
 *
 * @author Lichaojie
 * @version 2019/5/17 11:48
 */
public class Batman extends SuperPowerHuman {

	public Batman(Human human){
		super(human);
	}

	public void fly(){
		System.out.println("Batman flies.");
	}
}
