package common.thread.produce$consume;

/**
 * TestProject common.thread.produce$consume
 *
 * @author Lichaojie
 * @version 2018/5/14 15:16
 */
public interface Storage {
	void produce(int num);
	void consume(int num);

}
