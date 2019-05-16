package pattern.facade;

/**
 * TestProject pattern.facade
 *
 * @author Lichaojie
 * @version 2019/5/16 16:46
 */
public class LeaveFacade {

	private LightSystem lightSystem;

	private SecuritySystem securitySystem;

	private TemperatureSystem temperatureSystem;

	public void leaveWork(){
		lightSystem.lightOff();
		temperatureSystem.AirConditionerOff();
		securitySystem.WindowClose();
		securitySystem.DoorClose();
	}

	public LightSystem getLightSystem() {
		return lightSystem;
	}

	public void setLightSystem(LightSystem lightSystem) {
		this.lightSystem = lightSystem;
	}

	public SecuritySystem getSecuritySystem() {
		return securitySystem;
	}

	public void setSecuritySystem(SecuritySystem securitySystem) {
		this.securitySystem = securitySystem;
	}

	public TemperatureSystem getTemperatureSystem() {
		return temperatureSystem;
	}

	public void setTemperatureSystem(TemperatureSystem temperatureSystem) {
		this.temperatureSystem = temperatureSystem;
	}
}
