package common.lambda;

import java.util.Arrays;

/**
 * TestProject common.lambda
 *
 * @author Lichaojie
 * @version 2018/4/9 11:47
 */
public class LambdaTest {
	public static void main(String[] args){
		Integer[] array = new Integer[]{1,2,3,4,5};
		Arrays.asList(array).forEach(System.out::println);

		int[] a = new int[]{1,2,3,4,5};
		Arrays.asList(a).forEach(System.out::println);
		Arrays.stream(array).filter(n -> n > 2).map(n -> n = (int)Math.pow(n,2)).forEach(n -> System.out.print(n + " "));


		TestFunction<Integer,Integer,String> testFunction = (x, y, z) -> {
			System.out.println(x + " + " + y + " = "  + (x + y));
			System.out.println("Hello " + z);
		};
		testFunction.test(1,2,"kristy");

	}

	public void test(){
		TestFunction<Integer,Integer,String> testFunction = (x, y, z) -> {
			System.out.println(x + " + " + y + " = "  + (x + y));
			System.out.println("Hello " + z);
		};
	}
}

@FunctionalInterface
interface TestFunction<X,Y,Z>{
	void test(X x, Y y, Z z);
}

