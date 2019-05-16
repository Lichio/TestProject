package pattern.adapter;

/**
 * TestProject pattern.adapter
 *
 * @author Lichaojie
 * @version 2019/5/15 18:24
 */
public class PowerAdapter implements IPower220v {

	private Power110v power110v;

	@Override
	public Power220v output220v() {
		return transfer(power110v.output110v());
	}

	public Power110v getPower110v() {
		return power110v;
	}

	public void setPower110v(Power110v power110v) {
		this.power110v = power110v;
	}

	private Power220v transfer(Power110v power110v){
		// do transfer.
		return new Power220v();
	}
}
