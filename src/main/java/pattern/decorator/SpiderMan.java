package pattern.decorator;

import sun.security.provider.ConfigFile;

/**
 * TestProject pattern.decorator
 *
 * @author Lichaojie
 * @version 2019/5/17 11:33
 */
public class SpiderMan extends SuperPowerHuman {

	public SpiderMan(Human human){
		super(human);
	}


	public void absorb(){
		System.out.println("Spiderman absorbs.");
	}
}
