package org.ztest.test6;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.*;

/**
 * TestProject org.test.test21
 *
 * @author Lichaojie
 * @version 2018/3/27 14:38
 */
public class Test implements Cloneable,Runnable{

	static int i = 0;

	public static void main(String[] args){
//		List list = new ArrayList();
//		int i = 0;
//		while (true){
//			list.add(String.valueOf(i).intern());
//		}


		String str1 = new String("Hello World!");
		str1.intern();
		String str = "Hello World!";
		System.out.println(str == str1);
		System.out.println(System.identityHashCode(str));
		System.out.println(str.hashCode());
		System.out.println(System.identityHashCode(str1));
		//System.out.println(str1 == str2);
		//System.out.println(str == str2);

		String s = "abc";
		String r = "虫";
		try {
			System.out.println(s.getBytes("UTF-8").length + " -- " + r.getBytes("UTF-8").length);
			System.out.println();
		}catch (UnsupportedEncodingException e){

		}

		String ss = "I am a student,hello.world";
		StringTokenizer stringTokenizer = new StringTokenizer(ss);

		while (stringTokenizer.hasMoreTokens()){
			System.out.println(stringTokenizer.nextToken());
		}

		int[] array = new int[10];
		ArrayList<Integer> list = new ArrayList(100);
		int i = 0;
		while (i < 100){
			list.add(i ++);
		}
		list.stream().filter(n -> n % 10 == 0).map(n -> n = n + 1).forEach(n -> System.out.print(n + " "));


		//t();
	}

	public static void t(){
		System.out.println(i ++);
		t();
	}


	public static void main5(String[] args) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int A = in.nextInt();
		int X = in.nextInt();
		int B = in.nextInt();
		int Y = in.nextInt();

		HashMap<Integer,Integer> map = new HashMap<>();
		for (int x = 0; x * A < K && x <= X; x ++){
			int y = (K - x * A) / B;
			if((K - x * A) % B == 0 && y <= Y){
				map.put(x,y);
			}
		}

		BigInteger bigInteger = new BigInteger("0");
		for (int n : map.keySet()){
			int x = n;
			int y = map.get(x);
			if(x <= X && y <= Y){
				BigInteger bigInteger1 = new BigInteger(Long.toString(compute(X,n)));
				BigInteger bigInteger2 = new BigInteger(Long.toString(compute(Y,map.get(n))));
				bigInteger = bigInteger.add(bigInteger1.multiply(bigInteger2));
			}
		}


		System.out.println(bigInteger.remainder(new BigInteger("1000000007")).longValue());


	}

	public static long compute(int T,int t){
		long sum1 = 1,sum2 = 1;
		for (int i = 1; i <= t; i ++){
			sum1 *= i;
		}

		for (int i = T;i >= T - t + 1; i --){
			sum2 *= i;
		}

		return sum2 / sum1;
	}

	public static void main4(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long sum = (long)n * (long) m / 2;
		System.out.println(sum);
	}



	public static void main3(String[] args){
		try {
			Test test = (Test) (new Test()).clone();
		}catch (CloneNotSupportedException e){
			e.printStackTrace();
		}


		assert 1 + 1 == 2 : 88;
		Thread thread = new Thread(new Test());

		out1:
		for (int i = 0 ; i < 2; i ++){
			out2:
			for (int j = 0 ; j < 2; j ++){
				for (int r = 0; r < 100; r ++){
					System.out.println(r);
					if(r >= 2) break out1;
				}
			}
		}

		int a = 1;
		int b = 2;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a :" + a + "   b : " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a :" + a + "   b : " + b);
	}

	@Override
	public void run(){

	}



//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//
//		int sum = 0;
//		for (int y = k + 1; y <= n; y ++){
//			int t = 0;
//			for (int x = k; x <= n;){
//				if(x % y >= k){
//					if(n >= x + y - k - 1){
//						sum += (y - k);
//						x = x + y - k;
//					}
//					//sum ++;
//					//x ++;
//					System.out.println("x :" + x + " -- y : " + y);
//				}else {
//					t ++;
//					x = t * y + k;
//				}
//			}
//		}
//
//		System.out.println(sum);
//
//	}
//
//	public static void test(){
//		try {
//			FileWriter writer = new FileWriter("C:\\Users\\lich_\\Desktop\\相关文档\\result.txt");
//			StringBuilder builder = new StringBuilder("x1");
//			for (int i = 2; i < 785; i ++){
//				builder.append(" + x" + i);
//			}
//			writer.write(builder.toString());
//			writer.close();
//		}catch (IOException e){
//			e.printStackTrace();
//		}
//	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//
//		int[][] work = new int[n][2];
//
//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < 2; j++){
//				work[i][j] = sc.nextInt();
//			}
//		}
//
//		int[] ability = new int[m];
//		for (int i = 0 ; i < m; i ++){
//			ability[i] = sc.nextInt();
//		}
//
//		int[] result = new int[m];
//		int temp = 0;
//		for (int i = 0; i < m; i ++){
//			for (int j = 0; j < n; j ++){
//				if(ability[i] >= work[j][0]){
//					temp = work[j][1];
//				}
//			}
//			result[i] = temp;
//		}
//
//
//		//Arrays.asList(result).forEach(System.out::println);
////		for (int num : result){
////			System.out.println(num);
////		}
//	}
}
