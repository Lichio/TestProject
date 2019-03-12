package org.ztest.test1;

import java.io.IOException;

import java.util.*;

/**
 * TestProject org.test.test5
 *
 * @author Lichaojie
 * @version 2018/9/5 10:26
 */


public class Main {
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		HashSet<Integer> methods = new HashSet<>();
		ArrayList<Integer> redundancy = new ArrayList<>();
		Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		String[] strings;
		for (int i = 0; i < n;i ++){
			String str = in.nextLine();
			//System.out.println(str);
			if(str.length() != 1){
				strings = str.split(" ");
				ArrayList<Integer> list = new ArrayList<>(8);
				for (int j = 1; j < strings.length; j ++){
					int t = Integer.parseInt(strings[j]);
					list.add(t);
					methods.add(t);
				}
				methods.add(Integer.parseInt(strings[0]));
				map.put(Integer.parseInt(strings[0]),list);
			}else {
				methods.add(Integer.parseInt(str));
			}
		}

		for (int method : methods){
			if (method != 0){
				ArrayList<Integer> list = new ArrayList<>();
				HashSet<Integer> set = new HashSet<>();
				list.add(method);
				while (!list.isEmpty()){
					for (int key : map.keySet()){
						for (int m : list){
							if(map.get(key).contains(m)){
								set.add(key);
							}
						}
					}
					if(set.isEmpty()) break;
					list.clear();
					list.addAll(set);
					set.clear();
				}
				if(!list.contains(0)){
					redundancy.add(method);
				}
			}
		}

		HashMap<Integer,Integer> result = new HashMap<>();
		result.put(0,0);
		HashSet<Integer> tSet = new HashSet<>();
		for (int method : methods){
			if(method != 0 && !redundancy.contains(method)){
				for (int key : map.keySet()){
					if(map.get(key).contains(method)){
						tSet.add(key);
					}
				}
				tSet.removeAll(redundancy);
				result.put(method,tSet.size());
				tSet.clear();
			}
		}

//		methods.forEach(m -> System.out.print(m + " "));
//		System.out.println();
//		redundancy.forEach(m -> System.out.print(m + " "));
//		System.out.println();
		for (int key : result.keySet()){
			System.out.println(key + " " + result.get(key));
		}
	}



	public static void main7(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		final int LIMIT=n*3;
		Set<IntTriple> triples = new HashSet<>();
		for (int s = 3; s * s <= LIMIT; s += 2) {
			for (int t = s - 2; t > 0; t -= 2) {
				if (gcd(s, t) == 1) {
					int a = s * t;
					int b = (s * s - t * t) / 2;
					int c = (s * s + t * t) / 2;
					if (a + b + c <= LIMIT && a <= n && b <= n && c <= n)
						triples.add(new IntTriple(a, b, c));
				}
			}
		}

//		for (IntTriple triple : triples){
//			System.out.println(triple.a + " " + triple.b + " " + triple.c);
//		}

		System.out.println(triples.size());
	}

	public static int gcd(int x, int y) {
		if (x < 0 || y < 0)
			throw new IllegalArgumentException("Negative number");
		while (y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return x;
	}


	private static final class IntTriple {

		public final int a;
		public final int b;
		public final int c;


		public IntTriple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}


		public boolean equals(Object obj) {
			if (!(obj instanceof IntTriple))
				return false;
			else {
				IntTriple other = (IntTriple)obj;
				return a == other.a && b == other.b && c == other.c;
			}
		}

		public int hashCode() {
			return a + b + c;
		}

	}








	public static void main6(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i ++){
			int n = in.nextInt();
			int m = in.nextInt();
			HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
			for (int j = 1; j < n; j ++){
				ArrayList<Integer> list = new ArrayList<>();
				for (int k = j + 1; k <= n; k ++){
					list.add(k);
				}
				map.put(j,list);
			}

			int x,y;
			for (int j = 0; j < m; j ++){
				x = in.nextInt();
				y = in.nextInt();
				if(map.keySet().contains(x)){
					if(map.get(x).contains(y)){
						map.get(x).remove(y);
					}
				}else if(map.keySet().contains(y)){
					if(map.get(y).contains(x)){
						map.get(y).remove(x);
					}
				}
			}

		}
	}


	public static void main5(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] aArr = new int[n];
		int[] bArr = new int[n];
		int[] cArr = new int[n];

		for (int i = 0; i < n; i ++){
			aArr[i] = in.nextInt();
			bArr[i] = in.nextInt();
			cArr[i] = in.nextInt();
		}

		int sum = 0;

		for (int i = 0; i < n; i ++){
			for (int j = 0; j < n; j ++){
				if(aArr[i] < aArr[j] && bArr[i] < bArr[j] && cArr[i] < cArr[j]){
					sum ++;
					break;
				}
			}
		}

		System.out.println(sum);
	}



	public static void main4(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i ++){
			String string = in.next();
			System.out.println(change(string));
		}

	}

	public static String change(String s){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); ){
			int loop = 1;
			int j;
			for (j = i + 1; j < s.length(); ){
				if(s.charAt(j) - s.charAt(j - 1) == 1){
					j ++;
					loop ++;
				}else {
					break;
				}
			}
			if(loop >= 4){
				sb.append(s.charAt(i));
				sb.append("-");
				sb.append(s.charAt(j - 1));
			}else {
				sb.append(s.substring(i,j));
			}
			i = j;
		}
		return sb.toString();
	}

	public static void main3(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] mins = new int[t];
		int[] maxs = new int[t];
		int n,k;
		for (int i = 0; i < t; i ++){
			n = in.nextInt();
			k = in.nextInt();
			if(n <= 2 || k <= 1 || k == n){
				mins[i] = 0;
				maxs[i] = 0;
			}else {
				mins[i] = 0;
				int m = (n + 1) / 2;
				if((n & 1) == 1){
					maxs[i] = (m - 1) - Math.abs(m - k);
				}else {
					if (k <= m){
						maxs[i] = (m - 1) - (m - k);
					}else{
						maxs[i] = (m - 1) - (k - m - 1);
					}
				}
			}
		}
		for (int i = 0; i < t; i ++){
			System.out.print(mins[i]);
			System.out.print(" ");
			System.out.println(maxs[i]);
		}

	}

	//µÈ²î
	public static boolean isDef(int[] arr){
		if(arr.length <= 2){
			return true;
		}

		int def = arr[1] - arr[0];
		for (int i = 2; i < arr.length; i ++){
			if(arr[i] - arr[i - 1] != def) return false;
		}
		return true;
	}

	public static boolean idMul(int[] arr){
		if(arr.length <= 2) return true;

		int mul;
		if(arr[0] != 0){
			mul = arr[1] / arr[0];
		}else {
			return false;
		}

		for (int i = 2; i < arr.length; i ++){
			if(arr[i - 1] != 0){
				if(arr[i]/arr[i - 1] != mul) return false;
			}else {
				return false;
			}
		}
		return true;
	}


	public static void main2(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int t = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i ++){
			arr[i] = in.nextInt();
		}

		int sum = 0;
		int len = k;
		int l,h;
		for (int i = 0; i < arr.length - len + 1; i ++){
			l = i;
			h = i + len;
			for (int j = l;j < h; j ++){
				if(getTimes(arr,j,h,arr[j]) >= t){
					sum ++;
					break;
				}
			}
		}
		System.out.println(sum);
	}

	// include l,exclude h
	static int getTimes(int[] arr,int l,int h,int x){
		int sum = 0;
		for (int i = l; i < h; i ++){
			if(arr[i] == x){
				sum ++;
			}
		}
		return sum;
	}

	public static void main1(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x,y;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n - 1; i ++){
			x = in.nextInt();
			y = in.nextInt();
			if(x < y){
				set.add(x);
			}else {
				set.add(y);
			}
		}
		System.out.println(2 * (n - 1) - set.size());
	}
}
