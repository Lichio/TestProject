package org.ztest.test8;

import java.util.*;

/**
 * TestProject org.test.test25
 *
 * @author Lichaojie
 * @version 2018/5/11 19:50
 *
 */
public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

	}




	public static void ssort(int[] source,int[] s2){
		int k;
		int flag = source.length;
		while (flag > 0){
			k = flag;
			flag = 0;
			for (int i = 0; i < k - 1;i ++){
				if(source[i] > source[i + 1]){
					int temp = source[i];
					source[i] = source[i + 1];
					source[i + 1] = temp;

					temp = s2[i];
					s2[i] = s2[i + 1];
					s2[i + 1] = temp;

					flag = i + 1;
				}
			}
		}
	}

	public static void main9(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m= in.nextInt();
		int[] s = new int[n];
		int[] t = new int[n];
		for (int i = 0; i < n; i ++){
			s[i] = in.nextInt();
			t[i] = in.nextInt();
			if(s[i] < 0 || s[i] > m || t[i] < 0 || t[i] > m) return;
		}

		ssort(s,t);

		int[] dp = new int[n];
		for (int i = 0; i < n; i ++){
			dp[i] = 1;
		}
		for (int i = 1; i < n; i++){
			for (int j =0; j < i; j ++){
				if(t[j] <= s[i] && s[j] < t[j]){
					if(t[i] > s[i] || t[i] <= s[j]){
						if(dp[j] + 1 > dp[i]){
							dp[i] = dp[j] + 1;
						}
					}
				}
			}
		}

		int max = 0;
		for (int i = 0 ; i < n; i ++){
			if(dp[i] > max) max = dp[i];
		}
		System.out.println(max);
	}


	public static void main8(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i = 0 ; i < n; i ++){
			a[i] = in.nextInt();
		}
		for (int i = 0 ; i < n; i ++){
			b[i] = in.nextInt();
		}

		int l,r;
		int i = 0;
		int sum = 0;
		while (i < n){
			while (i < n && a[i] >= b[i]){
				i ++;
			}
			l = i;
			while (i < n && a[i] < b[i]){
				i ++;
			}
			r = i;

			for (int j = 1; j < r - l + 1; j ++){
				sum += j;
			}
		}

		System.out.println(sum);
	}

	public static void main7(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i = 0 ; i < n; i ++){
			a[i] = in.nextInt();
		}
		for (int i = 0 ; i < n; i ++){
			b[i] = in.nextInt();
		}

		long[] maxA = new long[n];
		long[] minB = new long[n];

		int sum = 0;
		for (int i = 0 ; i < n ; i ++){
			if(a[i] >= b[i]) continue;
			for (int j = i; j < n; j++){
				if(j == i){
					maxA[j] = a[j];
					minB[j] = b[j];
				}

				if(j > i && a[j] < maxA[j - 1]){
					maxA[j] = maxA[j - 1];
				}else {
					maxA[j] = a[j];
				}

				if(j > i && b[j] > minB[j - 1]){
					minB[j] = minB[j - 1];
				}else {
					minB[j] = b[j];
				}
			}

			for (int j = i; j < n; j ++){
				if(maxA[j] < minB[j]) sum ++;
			}
		}
		System.out.println(sum);
	}


	public static void main6(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i ++){
			a[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] q = new int[m];
		for (int i = 0 ; i < m; i ++){
			q[i] = in.nextInt();
		}

		for (int i = 1; i < n; i ++){
			a[i] = a[i - 1] + a[i];
		}

		for (int i = 0 ; i < m; i ++){
//			for (int j = 0 ; j < n; j ++){
//				if(q[i] <= a[j]) {
//					System.out.println(j + 1);
//					break;
//				}
//			}
			System.out.println(search(a,q[i]) + 1);
		}
	}

	public static int search(int[] array,int n){
		int l = 0;
		int r = array.length - 1;
		if(n > array[r]) return -1;
		while (l <= r){
			int m = l + (r - l) / 2;
			if(n > array[m]){
				l = m + 1;
			}else if(n < array[m]){
				if(m == 0 || n > array[m - 1]) return m;
				r = m - 1;
			}else {
				return m;
			}
		}
		return -1;
	}

	public static void main5(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] score = new int[n];
		int[] flag = new int[n];
		for (int i = 0; i < n; i ++){
			score[i] = in.nextInt();
		}
		for (int i = 0; i < n; i ++){
			flag[i] = in.nextInt();
		}
		int sum = 0;
		for (int i = 0; i < n; i ++){
			if(flag[i] == 1) sum += score[i];
		}

		//int[] scores = new int[n - k + 1];
		int max = 0;
		for (int i = 0; i < n - k + 1; i ++){
			int j = i;
			int result = 0;
			while (j < i + k){
				if(flag[j] == 0){
					result += score[j];
				}
				j ++;
			}
			if(max < result) max = result;
		}
		System.out.println(max + sum);
	}

	public static void main4(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i ++){
			sb.append("a");
		}
		for (int i = 0 ; i < m; i ++){
			sb.append("z");
		}

		ArrayList<String> list = Permutation(sb.toString());
		if(k > list.size()){
			System.out.println(-1);
		}else {
			System.out.println(list.get(k - 1));
		}

	}

	public static ArrayList<String> Permutation(String str) {
		if(str == null) return null;
		if(str.length() == 0) return new ArrayList<>();

		if(str.length() == 1){
			ArrayList<String> list = new ArrayList<>(1);
			list.add(str);
			return list;
		}

		char c = str.charAt(0);
		ArrayList<String> list = Permutation(str.substring(1,str.length()));

		HashSet<String> strSet = new HashSet<>();
		for (String s : list){
			strSet.add(c + s);
			char[] chars = s.toCharArray();
			for (int i = 0 ; i < chars.length ; i ++){
				char ct = chars[i];
				chars[i] = c;
				strSet.add(ct + new String(chars));
				chars[i] = ct;
			}
		}

		ArrayList<String> strList = new ArrayList<>(strSet.size());
		strList.addAll(strSet);
		Collections.sort(strList);
		return (strList);
	}

	public static void main3(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		String s = in.nextLine();
		if("".equals(s)){
			System.out.println(0);
			return;
		}
		String[] ss = s.split(" ");
		for (String str : ss){
			list.add(Integer.parseInt(str));
		}

		Collections.sort(list);
//		ArrayList<Integer> list1 = new ArrayList();
//		ArrayList<Integer> list2 = new ArrayList();
//		ArrayList<Integer> list3 = new ArrayList();
//		ArrayList<Integer> list4 = new ArrayList();


		int n = 0;
		out1:
		while (!list.isEmpty()){
			int length = list.size();
			int flag = 0;
			if(list.get(length - 1) > 200){
				list.remove(length - 1);
				n ++;
				continue;
			}
			if(list.get(length - 1) == 200){
				if(list.get(0) == 100){
					list.remove(length - 1);
					list.remove(0);
					n ++;
					continue;
				}else {
					list.remove(length - 1);
					n ++;
					continue;
				}
			}
			if(list.get(length - 1) + list.get(0) > 300){
				list.remove(length - 1);
				n ++ ;
				continue ;
			}
			if(list.get(length - 1) == 100) break;
			out2:
			for (int i = length - 2; i >= 0; i --){

				int W = list.get(length - 1) + list.get(i);
				if(W > 200 && W <= 300){
					list.remove(length - 1);
					list.remove(i);
					n ++;
					flag = 1;
					break out2;
				}else if(W == 200){
					break out1;
//					if(list.get(0) == 100){
//						list.remove(length - 1);
//						list.remove(i);
//						list.remove(0);
//						n ++;
//						flag = 1;
//						break out2;
//					}else {
//						list.remove(length - 1);
//						list.remove(i);
//						n ++;
//						flag = 1;
//						break out2;
//					}
				}
			}
			if(flag == 0){
				list.remove(length - 1);
				n ++;
			}
		}
		if(!list.isEmpty()){
			int size = list.size();
			int m = size % 3 == 0 ? size / 3 : size / 3 + 1;
			n = n + m;
		}
		System.out.println(n);
	}

	public static void main2(String[] args){

		int n = 0;
		double b = 0.0;
		double temp = 0.0;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		if(n == 1) {
			System.out.println("Alice");
		}
		if(n == 2) {
			System.out.println("Bob");
		}
		if(n == 3) {
			System.out.println("Cathy");
		}
		if(n == 4) {
			System.out.println("Dave");
		}

		for (int i = 2; ; i++) {
			b += Math.pow(2, i);
			if(n - b <= Math.pow(2, i+1)) {
				temp = (n - b)/Math.pow(2, i+1);
				break;
			}
		}

		sc.close();

		if(temp > 0 && temp <= 0.25) {
			System.out.println("Alice");
		}
		if(temp > 0.25 && temp <= 0.50) {
			System.out.println("Bob");
		}
		if(temp > 0.50 && temp <= 0.75) {
			System.out.println("Cathy");
		}
		if(temp > 0.75 && temp <= 1) {
			System.out.println("Dave");
		}
	}

	public static void main1(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[][] constraint = new int[m][2];
		for (int i = 0 ; i < m; i ++){
			constraint[i][0] = in.nextInt();
			constraint[i][1] = in.nextInt();
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < m - 1; i ++){
			for (int j = i + 1; j < m ; j ++){
				list.add(check(constraint[i][0],constraint[i][1],constraint[j][0],constraint[j][1]));
			}
		}
		for (int i = 0 ; i< list.size() - 1; i ++){
			int t = list.get(i);
			if(t % 2 == 0){
				for (int j = i ;  j < list.size(); j ++){
					if(list.get(j) == t - 1) System.out.println("no");
				}
			}else {
				for (int j = i ;  j < list.size(); j ++){
					if(list.get(j) == t + 1) System.out.println("no");
				}
			}
		}
		System.out.println("yes");
	}

	public static int check(int a1,int a2,int b1,int b2){
		if(a1 == b1){
			if(a2 % 2 == 0 && b2 + 1 == a2 || b2 % 2 == 0 && a2 + 1 == b1) return a1;
		}
		if(a1 == b2){
			if(a2 % 2 == 0 && b1 + 1 == a2 || b1 % 2 == 0 && a2 + 1 == b1) return a1;
		}
		if(a2 == b1){
			if(a1 % 2 == 0 && b2 + 1 == a1 || b2 % 2 == 0 && a1 + 1 == b2) return a2;
		}
		if(a2 == b2){
			if(a1 % 2 == 0 && b1 + 1 == a1 || b1 % 2 == 0 && a1 + 1 == b1) return a2;
		}

		return 0;

	}
}


