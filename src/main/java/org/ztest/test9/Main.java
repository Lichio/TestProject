package org.ztest.test9;

import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;

/**
 * TestProject org.test.test26
 *
 * @author Lichaojie
 * @version 2018/8/12 10:53
 */

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		LRUCache cache = new LRUCache(n);
		ArrayList<Integer> list = new ArrayList<>();
		int a = 0;
		int b = 0;
		while (in.hasNext()) {//注意while处理多个case

			String line = in.nextLine();
			String[] strs = line.split(" ");
			if(strs.length == 3){
				a = Integer.parseInt(strs[1]);
				b = Integer.parseInt(strs[2]);
				cache.put(a,b);
			}else {
				a = Integer.parseInt(strs[1]);
				System.out.println(cache.get(a));
			}

//			String operation = in.next();
//			if(operation != null && operation.length()>0){
//				char o = operation.charAt(0);
//				if(o == 'p'){
//					a = in.nextInt();
//					b = in.nextInt();
//					cache.put(a,b);
//				}else {
//					a = in.nextInt();
//					System.out.println(cache.get(a));
//				}
//			}

		}
//		list.forEach(System.out::println);
	}

	static class LRUCache {

		private int capacity;

		// 维护缓存中数据的访问顺序
		private LinkedList<Integer> list;

		// 存储缓存数据
		private HashMap<Integer, Integer> map;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			list = new LinkedList<>();
			map = new HashMap<>();
		}

		public Integer get(Integer key) {
			if (map.containsKey(key)) {
				list.removeFirstOccurrence(key);
				list.addFirst(key);
				return map.get(key);
			} else {
				return -1;
			}
		}

		public void put(Integer key, Integer value) {
			if (!map.containsKey(key)) { //插入
				if (list.size() == capacity) { // 缓存满
					Integer last = list.removeLast();
					map.remove(last);
				}
				list.addFirst(key);
				map.put(key, value);
			} else { // 更新
//				list.removeFirstOccurrence(key);
//				list.addFirst(key);
				map.put(key, value);
			}
		}
	}


	public static void main9(String[] args){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		String str = Long.toBinaryString(n);
		char[] chars = str.toCharArray();
		int num = 0;
		for (char c : chars){
			if (c == '1'){
				num ++;
			}
		}
		System.out.println(num);
	}




	public static void main8(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] checkerboard = new char[n][m];
		for (int i =0; i < n; i ++){
			String line = in.next();
			for (int j = 0; j < m; j ++){
				checkerboard[i][j] = line.charAt(j);
			}
		}

		for (int j = 0; j < m; j ++){
			for (int i = n - 2; i >= 0; i --){
				if(checkerboard[n - 1][j] == 'o') checkerboard[n - 1][j] = '.';
				for (int k = i; k < n - 1; k ++){
					if(checkerboard[k][j] != 'x'){
						if(checkerboard[k + 1][j] == '.'){
							checkerboard[k + 1][j] = checkerboard[k][j];
							checkerboard[k][j] = '.';
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i ++){
			for (int j = 0; j < m; j ++){
				System.out.print(checkerboard[i][j]);
			}
			System.out.println();
		}
	}

	public static void main7(String[] args){
		Scanner in = new Scanner(System.in);
		int hp = in.nextInt();
		int normalAttack = in.nextInt();
		int buffedAttack = in.nextInt();

		int times;
		if(2 * normalAttack >= buffedAttack){
			if(hp % normalAttack == 0){
				times = hp / normalAttack;
			}else {
				times = hp / normalAttack + 1;
			}
		}else {
			if(hp % buffedAttack == 0){
				times = (hp / buffedAttack) * 2;
			}else {
				int mmod = hp % buffedAttack;
				if(mmod <= normalAttack){
					times = (hp / buffedAttack) * 2 + 1;
				}else {
					times = (hp / buffedAttack) * 2 + 2;
				}
			}
		}
		System.out.println(times);
	}

	public static void main6(String args[]) {
		Scanner reader = new Scanner(System.in);
		int x = reader.nextInt();
		int y = reader.nextInt();
		int[][] array = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				array[i][j] = reader.nextInt();
			}
		}
		System.out.println(minHP(array));
	}
	public static int minHP(int[][] m) {
		int[][] min = new int[m.length][m[0].length];
		min[0][0] = m[0][0];
		for (int i = 1 ; i < min.length; i ++){
			min[i][0] = min[i - 1][0] + m[i][0];
		}
		for (int i = 1;i < min[0].length; i ++){
			min[0][i] = min[0][i - 1] + m[0][i];
		}

		ArrayList<Integer> listX = new ArrayList<>();
		ArrayList<Integer> listY = new ArrayList<>();

		listX.add(0);
		listY.add(0);

		for (int i = 1; i < min.length; i ++){
			for (int j = 1; j < min[0].length; j ++){
				if(min[i - 1][j] > min[i][j - 1]){
					min[i][j] = m[i][j] + min[i - 1][j];
					listX.add(i - 1);
					listY.add(j);
				}else {
					min[i][j] = m[i][j] + min[i][j - 1];
					listX.add(i);
					listY.add(j - 1);
				}
			}
		}

		for (int i = min.length - 1; i >= 0; i --){
			for (int j = min[0].length - 1; j >= 0; j --){
				if(min[i - 1][j] > min[i][j - 1]){
					listX.add(i - 1);
					listY.add(j);
				}else{
					listX.add(i);
					listY.add(j - 1);
				}
			}
		}

		int minn = min[0][0];
		for (int i = 1 ; i < listX.size(); i ++){
			if (minn > min[listX.get(i)][listY.get(i)]){
				minn = min[listX.get(i)][listY.get(i)];
			}
		}
		return minn >= 0 ? 0 : Math.abs(minn) + 1;
	}



	public static void main5(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int score[] = new int[num];
		int time[] = new int[num];
		for (int i = 0; i < num; i++) {
			score[i] = scanner.nextInt();
		}
		for (int i = 0; i < num; i++) {
			time[i] = scanner.nextInt();
		}
		int totalTime = scanner.nextInt();
		System.out.println(getScore(score, time, totalTime));
	}
	public static int getScore(int score[], int time[], int totalTime) {
		int[][] dp = new int[score.length][totalTime + 1];
		for (int i = 0 ; i < totalTime + 1; i ++){
			if(i < time[0]){
				dp[0][i] = 0;
			}else {
				dp[0][i] = score[0];
			}
		}
		for (int i = 0 ; i < score.length; i ++){
			dp[i][0] = 0;
		}

		for (int i = 1 ; i < score.length; i ++){
			for (int j = 1; j < totalTime + 1; j ++){
				if(j - time[i] >= 0){
					dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - time[i]] + score[i]);
				}else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		for (int i = 0 ; i < score.length; i ++){
			for (int j = 0; j < totalTime + 1; j ++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[score.length - 1][totalTime];
	}


	public static void main4(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger[] bigs = new BigInteger[n];
		for (int i = 2; i < n; i ++){
			bigs[i] = new BigInteger("0");
		}
		if(n == 1){
			bigs[0] = new BigInteger(10 + "");
		}
		if(n == 2){
			bigs[1] = new BigInteger(100 + "");
		}
		for (int i = 3; i < n + 1; i ++){
			int x = i - 2;
			if((x & 1) == 1){
				for (int j = 1;j <= x; j +=2){
					for (int k = 0;k <j;k++){
						bigs[i - 1].add(bigs[k]);
					}
				}
			}else {
				for (int j = 2;j<=x;j +=2){
					for (int k = 0;k <j;k++){
						bigs[i -1].add(bigs[k]);
					}
				}
			}

			x = i - 1;
			for (int j = 1; j < x; j ++){
				bigs[i -1].add(bigs[j - 1].multiply(bigs[x - j - 1]).multiply(new BigInteger("2")));
			}
		}

		System.out.println(bigs[n - 1].mod(new BigInteger("1000000007")));

	}


	public static void main3(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		boolean[] ta = new boolean[t];
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < t; i ++){
			int n = in.nextInt();
			for (int j = 0; j < n; j ++){
				strings.add(in.next());
			}

			ta[i] = compute(strings);

			strings.clear();
		}

		for (boolean nn : ta){
			if(nn){
				System.out.println("Yeah");
			}else {
				System.out.println("Sad");
			}
		}
	}

	public static boolean compute(ArrayList<String> strings){
		ArrayList<String> list = new ArrayList<>();
		String s;
		StringBuilder sb;
		for (int i = 0 ;i < strings.size(); i ++){
			s = strings.get(i);
			for (int k = 0; k < s.length(); k ++) {
				sb = new StringBuilder();
				sb.append(s.substring(k));
				sb.append(s.substring(0, k));
				list.add(sb.toString());
				list.add(sb.reverse().toString());
			}

			for (int k = 0; k < strings.size(); k ++){
				if(k != i && list.contains(strings.get(k))){
					return true;
				}
			}
			list.clear();
		}
		return false;
	}



	public static void main2(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] l = new int[n];
		int[] h = new int[n];
		int[] index = new int[n];
		for (int i = 0; i < n; i ++){
			l[i] = in.nextInt();
			h[i] = in.nextInt();
			index[i] = i + 1;
		}

		ssort(l,h,index);

		int error = 0;
		int errorIndex = 0;
		for (int i = 0; i < n - 1; i ++){
			if(h[i] > l[i + 1]){
				error ++;
				errorIndex = i;
			}
		}

		if(error > 1){
			System.out.println(0);
		}else if(error == 1){
			if(errorIndex == n - 2){
				if(h[errorIndex - 1] <= l[errorIndex + 1]){
					System.out.println(2);
					if(index[errorIndex] < index[errorIndex + 1]){
						System.out.print(index[errorIndex] + " " + (index[errorIndex + 1]));
					}else {
						System.out.print(index[errorIndex + 1] + " " + (index[errorIndex]));
					}
				}else {
					System.out.println(1);
					System.out.println(index[errorIndex + 1]);
				}
			}else {
				if(h[errorIndex] <= l[errorIndex + 2]){
					System.out.println(2);
					if(index[errorIndex] < index[errorIndex + 1]){
						System.out.print(index[errorIndex] + " " + (index[errorIndex + 1]));
					}else {
						System.out.print(index[errorIndex + 1] + " " + (index[errorIndex]));
					}
				}else {
					System.out.println(1);
					System.out.println(index[errorIndex]);
				}
			}

		}else {
			System.out.println(n);
			for (int i = 1; i <= n; i ++){
				System.out.print(i + " ");
			}
		}
	}

	public static void ssort(int[] source,int[] s2,int[] index){
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

					temp = index[i];
					index[i] = index[i + 1];
					index[i + 1] = temp;

					flag = i + 1;
				}

				if(source[i] == source[i + 1]){
					if(s2[i] < s2[i + 1]){
						int temp = s2[i];
						s2[i] = s2[i + 1];
						s2[i + 1] = temp;

						temp = index[i];
						index[i] = index[i + 1];
						index[i + 1] = temp;
					}
				}
			}
		}
	}

}






class Main1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeSet ts = new TreeSet();
		for (int i = 0; i < n; i++) {
			int b = sc.nextInt();
			int e = sc.nextInt();
			ts.add(new Order(b,e));
		}
		Order tmp = null;
		int res = -1;
		for(Iterator iter = ts.iterator();iter.hasNext();){
			res++;
			Order order = (Order)iter.next();
//            System.out.println(order.l);
			if(tmp == null) {
				tmp = order;
				continue;
			}
			if(order.l < tmp.r){
				if(order.r < tmp.r){
					System.out.println(2);
					System.out.println(res+" "+ ++res);
				}
				else if(order.r < ((Order)(iter.next())).l){
					System.out.println(2);
					System.out.println(res+" "+ ++res);
				}
				else {
					System.out.println(1);
					System.out.println(res);
				}
				return;
			}
			tmp = order;
		}
		System.out.println(n);
		for (int i = 1; i <= n; i++) {
			System.out.print(i+" ");
		}

	}

}

class Order implements Comparable{
	int l,r;

	public Order(int l, int r) {
		this.l = l;
		this.r = r;
	}
	@Override
	public int compareTo(Object o){
		return this.l - ((Order)o).l;
	}
}









class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public static void main2(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < n; i ++){
			h[i] = in.nextInt();
		}

		int minIndex = 0;
		for (int i = 0; i < n; i ++){
			if(h[i] < h[minIndex]) minIndex = i;
		}
		int t = h[minIndex];
		h[minIndex] = h[n - 1];
		h[n - 1] = t;

		int sum = 0;
		for (int i = 0; i < n - 1; i ++){
			sum += h[i];
		}

		System.out.println(sum);

	}


	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new LinkedList<>();
		if (intervals == null || intervals.size() < 1) {
			return res;
		}
		Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

		Interval prev = null;
		for (Interval item : intervals) {

			if (prev == null || prev.end < item.start) {
				res.add(item);
				prev = item;
			} else if (prev.end < item.end) {
				prev.end = item.end;
			}
		}

		return res;
	}

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();

		List<Interval> listA = new LinkedList<Interval>();
		List<Interval> resA;
		sc.nextLine();

		for(int i = 0; i < m; i++) {
			String[]  singles = sc.nextLine().split(";");
			for(int j = 0; j < singles.length; j++) {
				String[] temp = singles[j].split(",");
				Interval interval = new Interval(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				listA.add(interval);
			}
		}

		resA = merge(listA);

		for(int i = 0; i < resA.size(); i++) {
			Interval tempInterval = resA.get(i);
			if(i==0) {
				System.out.print(tempInterval.start+","+tempInterval.end);
			} else {
				System.out.print(";"+tempInterval.start+","+tempInterval.end);
			}
		}

		sc.close();
	}
}