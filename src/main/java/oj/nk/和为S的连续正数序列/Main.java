package oj.nk.和为S的连续正数序列;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TestProject oj.nk.和为S的连续正数序列
 *
 * @author Lichaojie
 * @version 2018/5/15 21:11
 */
public class Main {
	public static void main(String[] args){
		FindContinuousSequence(3);
	}

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int n = 0;
		int x = 0;

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		int N = (int) Math.sqrt(2 * sum);
		for (n = 2; n <= N;n ++){
			x = (2 * sum / n + 1 - n) / 2;
			if(n * (2 * x + n - 1) == 2 * sum){
				ArrayList<Integer> list = new ArrayList<>(n);
				for (int i = 0; i < n; i ++){
					list.add(x + i);
				}
				lists.add(list);
			}
		}

		Collections.reverse(lists);
		return lists;
	}
}
