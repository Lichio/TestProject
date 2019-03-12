package oj.nk.和为S的两个数字;

import java.util.ArrayList;

/**
 * TestProject oj.nk.和为S的两个数字
 *
 * @author Lichaojie
 * @version 2018/5/15 21:40
 */
public class Main {
	public static void main(String[] args){
		int[] array = new int[]{1,2,4,6,7,9,12};
		FindNumbersWithSum(array,10);
	}
	public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
		int left = 0;
		int right = array.length - 1;

		int n1 = 0,n2 = 0,nn = 0;

		int lr;
		while (left < right){
			lr = array[left] + array[right];
			if(lr > sum){
				right --;
			}else if(lr < sum) {
				left ++;
			}else {
				if(nn == 0 || array[left] * array[right] < nn){
					n1 = array[left];
					n2 = array[right];
					nn = n1 * n2;
				}
				left ++;
				right --;
			}
		}


		if(nn == 0){
			return new ArrayList<>();
		}else {
			ArrayList<Integer> list = new ArrayList<>(2);
			list.add(n1);
			list.add(n2);
			return list;
		}


	}
}
