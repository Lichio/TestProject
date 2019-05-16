package pattern.adapter;

/**
 * TestProject pattern.adapter
 *
 * @author Lichaojie
 * @version 2019/5/15 18:25
 */
public class Power110v {
	Power110v output110v(){
		return new Power110v();
	}
}
