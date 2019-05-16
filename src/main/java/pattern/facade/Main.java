package pattern.facade;

/**
 * TestProject pattern.facade
 *
 * @author Lichaojie
 * @version 2019/5/16 16:50
 */
public class Main {
	public static void main(String[] args){
		LeaveFacade facade = new LeaveFacade();
		facade.setLightSystem(new LightSystem());
		facade.setSecuritySystem(new SecuritySystem());
		facade.setTemperatureSystem(new TemperatureSystem());

		facade.leaveWork();
	}
}
