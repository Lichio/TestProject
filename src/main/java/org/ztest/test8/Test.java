package org.ztest.test8;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.*;

/**
 * TestProject org.test27
 *
 * @author Lichaojie
 * @version 2018/3/23 21:58
 */
public class Test{

	public static void main(String[] args){
		List<String> list1 = new ArrayList<String>();
		List<Object> list2 = new ArrayList<Object>();

		BitSet bitSet = new BitSet(15);
		bitSet.clear();
		bitSet.set(4);
		System.out.println(bitSet.toString());

		Object object = new Object();
		ReferenceQueue queue = new ReferenceQueue();
		SoftReference reference = new SoftReference(object,queue);


	}

	@Override
	public Object clone(){
		return new Object();
	}
	
	public static void main12(String[] args){
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
			String str = in.nextLine();
			int i = 0;
			while (i < str.length()){
				char c = str.charAt(i);
				if(!Character.isDigit(c)){
					String[] strings = str.split(c+"");
					for (int j = 0; j < strings.length - 1; j ++){
						if (strings[j].equals(strings[j + 1])){
							strings[j] = "";
						}
					}
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < strings.length; j ++){
						if(!strings[j].equals("")){
							if(j != 0){
								sb.append(c);
							}
							sb.append(strings[j]);
						}
					}
					str = sb.toString();
				}
				i ++;
			}
			System.out.println(str);
		}
	}

	public static void main11(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		if (n < 1)
			return;
		int maxValue = 6;
		int[][] probabilities = new int[2][];
		probabilities[0] = new int[maxValue * n + 1];
		probabilities[1] = new int[maxValue * n + 1];
		int flag = 0;
		for (int i = 1; i <= maxValue; i++)
			probabilities[0][i] = 1;
		for (int k = 2; k <= n; ++k) {
			for (int i = 0; i < k; ++i)
				probabilities[1 - flag][i] = 0;
			for (int i = k; i <= maxValue * k; ++i) {
				probabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= maxValue; ++j)
					probabilities[1 - flag][i] += probabilities[flag][i - j];
			}
			flag = 1 - flag;
		}
		double total = Math.pow(maxValue, n);
		System.out.print("[");
		for (int i = n; i <= maxValue * n; i++) {
			double ratio = (double) probabilities[flag][i] / total;
			System.out.print("[");
			System.out.print(i);
			System.out.printf(",%.5f]",ratio);
			if(i != maxValue * n) System.out.print(",");
		}
		System.out.print("]");
	}


	public static void main10(String[] args){
		Scanner in = new Scanner(System.in);
		int years = in.nextInt();
		int weeks = in.nextInt();

		Calendar c0 = Calendar.getInstance();
		c0.set(1900,0,1);

		Calendar c1 = Calendar.getInstance();
		c1.set(1900 + years - 1,11,31);

		long time = c0.getTimeInMillis();
		Calendar nextDay = Calendar.getInstance();
		nextDay.setTimeInMillis(time);

		int sum = 0;
		while (nextDay.compareTo(c1) <= 0){
			//System.out.println(nextDay.get(Calendar.DAY_OF_MONTH) + " " + nextDay.get(Calendar.DAY_OF_WEEK));
			if(nextDay.get(Calendar.DAY_OF_MONTH) == 13 && nextDay.get(Calendar.DAY_OF_WEEK) == weeks + 1) sum ++;
			long t = nextDay.getTimeInMillis();
			t += 24 * 60 * 60 * 1000;
			nextDay.setTimeInMillis(t);
		}
		System.out.println(sum);



	}



	public static void main9(String[] args){

		Scanner in = new Scanner(System.in);
		String str = in.next();
		int n = in.nextInt();

		if(n == 0 || str.length() == 0){
			System.out.println("");
			return;
		}

		int sum = 0;
		StringBuilder result = new StringBuilder();
		char c = ' ';
		for (int i = 0 ; i < str.length(); i ++){
			c = str.charAt(i);
			if(!Character.isDigit(c)){
				if((c >= 0x4e00)&&(c <= 0x9fbb)){
					sum += 2;
				}else {
					sum += 1;
				}

				if(sum < n){
					result.append(c);
				}else {
					break;
				}
			}
		}
		if(!Character.isDigit(c)) result.append(c);
		System.out.println(result);

//		int sum = 0;
//		for (int i = 0; i < str.length(); i ++){
//			char c = str.charAt(i);
//			if((c >= 0x4e00)&&(c <= 0x9fbb)){
//				sum += 2;
//			}else {
//				sum += 1;
//			}
//
//			if(sum >= n) break;
//		}
//
//		byte[] bytes;
//		String result = "";
//		try {
//			bytes = str.getBytes("GBK");
//			int m = sum > n ? sum : n;
//			byte[] bytes1 = new byte[m];
//			for (int i = 0; i < m; i ++){
//				bytes1[i] = bytes[i];
//			}
//			result = new String(bytes1,"GBK");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(result);
	}




	public static void main8(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int i = 1;
		int sum = 0;
		while (true){
			if(check(i)) {
				sum++;
			}
			if(sum == n){
				System.out.println(i);
				return;
			}
			i ++;
		}

	}

	public static boolean check(int n){
		while (n % 2 == 0){
			n /= 2;
		}
		while (n % 3 == 0){
			n /= 3;
		}
		while (n % 5 == 0){
			n /= 5;
		}
		return n == 1;
	}

	public static void main7(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int[] dp = new int[x + 1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= x; i ++){
			int p1 = dp[i - 1] + 1;
			int p2 = i % 2 == 1 ? dp[(i + 1) / 2] + 2 : Integer.MAX_VALUE;
			int p3 = i % 2 == 0 ? dp[i / 2] + 1 : Integer.MAX_VALUE;

			dp[i] = Math.min(Math.min(p1,p2),p3);
		}
		System.out.println(dp[x]);
	}

	public static void main6(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] array = new Integer[n + 1];
		for (int i = 0;i < n + 1; i ++){
			array[i] = 0;
		}
		for(int i = 0; i < n; i++){
			array[sc.nextInt()] = 1;
		}

		for (int i = 0 ; i < array.length; i ++){
			if(array[i] == 0) System.out.println(i);
		}
	}

	public static void main4(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		List<java.lang.String> list = new ArrayList<>(1000);
		for(int i = 0; i < t; i++){
			list.add(sc.next());
		}

		//list.forEach(System.out::println);

		int num;
		int flag;
		for (java.lang.String s : list){
			if(s.length() % 2 == 1){
				System.out.println("No");
				continue;
			}
			num = 0;
			flag = 0;
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i ++){
				if(chars[i] == '('){
					num ++;
				}else {
					num --;
				}

				if(num == -1) flag ++;
				if(num < -2 || flag > 1) {
					System.out.println("No");
					break;
				}
			}
			if(num == 0){
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}

		}
	}

	public static void main5(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<Integer> list = new ArrayList<>(1000);
		for (int i = 0; i < t; i ++){
			list.add(in.nextInt());
		}

		//list.forEach(System.out::println);

		int x;
		int y;
		for (int n : list){
			if(n % 2 == 1){
				System.out.println("No");
				continue;
			}

			while (n % 2 == 0){
				n /= 2;
			}

//			y = 2;
//			int Y = n / 3;
//			while (y <= Y){
//				x = n / y;
//				if(n % y == 0 && x % 2 == 1){
//					System.out.println(x + " " + y);
//					break;
//				}
//				y += 2;
//			}
//			if(y > Y) System.out.println("No");

//			int nn = n >> 1;
//			x = nn % 2 == 0 ? nn + 1 : nn;
//			out:
//			while (x > 0){
//				y = n / x;
//				if(n % x == 0 && y % 2 == 0) {
//					System.out.println(x + " " + y);
//					break out;
//				}
//				x -= 2;
//			}
//			if(x < 0) System.out.println("No");
		}
	}

	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> sumList = new ArrayList<>();
		String[] strings = new String[n];
		for (int i = 0 ; i < n; i ++){
			strings[i] = in.next();
		}

		int sum = 0;
		Stack<Long> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for (String s : strings){
			for (int i = 0 ; i < s.length(); i ++){
				char c = s.charAt(i);
				if(Character.isDigit(c)){
					long m = Long.parseLong(c +"");
					char tc;
					while (Character.isDigit(tc = s.charAt(++i))){
						m = m * 10 + Long.parseLong(tc + "");
					}
					i --;
					if(!stack2.isEmpty() && stack2.peek() == '*'){
						stack2.pop();
						stack1.pop();
						stack1.push(36L);
					}else {
						stack1.push(Long.parseLong(c + ""));
					}
				}else{
					stack2.push(c);
				}
			}
			sum = 0;
			while (!stack1.isEmpty()){
				sum += stack1.pop();
			}
			sumList.add(sum);
		}

		java.lang.String[][] printString = new java.lang.String[][]{
				{"66666","6...6","6...6","6...6","66666"},
				{"....6","....6","....6","....6","....6"},
				{"66666","....6","66666","6....","66666"},
				{"66666","....6","66666","....6","66666"},
				{"6...6","6...6","66666","....6","....6"},
				{"66666","6....","66666","....6","66666"},
				{"66666","6....","66666","6...6","66666"},
				{"66666","....6","....6","....6","....6"},
				{"66666","6...6","66666","6...6","66666"},
				{"66666","6...6","66666","....6","66666"}};

		for (int num : sumList){
			sum = num;

			ArrayList<Integer> list = new ArrayList<>();
			while (sum > 0){
				int temp = sum % 10;
				list.add(temp);
				sum /= 10;
			}

			Collections.reverse(list);

			for (int i = 0 ; i < 5; i ++){
				for (int j = 0; j < list.size(); j ++){
					if(j != 0){
						System.out.print("..");
					}
					System.out.print(printString[list.get(j)][i]);
				}
				System.out.println();
			}
		}


	}

	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] array = new int[n];


		for(int i = 0; i < n; i++){
			array[i] = sc.nextInt();
		}

		Arrays.sort(array);

		int sum = 0;
		for (int i = 0; i < n; i ++){
			if(i >= 1 && array[i] == array[i - 1]){
				continue;
			}
			for (int j = i + 1; j < n; j ++){
				if(array[j] - array[i] == k){
					sum ++;
					j = n;
				}
			}
		}

		System.out.println(sum);
	}

	public static void main3(String[] args){
		//main1(args);

		List<String> list = new ArrayList<>();
		list.add("string1");
		list.add("string2");

		String[] array = new String[]{"string1","string2"};
		//List list1 = Arrays.asList(array);
		//list.forEach(System.out::println);

		int[] result = new int[]{1,2,3,4};
		Arrays.asList(array).forEach(System.out::println);

		//result数组必须是引用类型
		(Arrays.asList(result)).forEach(System.out::println);


	}
}
