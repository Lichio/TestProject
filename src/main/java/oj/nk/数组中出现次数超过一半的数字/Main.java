package oj.nk.数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * TestProject oj.nk.数组中出现次数超过一半的数字
 *
 * @author Lichaojie
 * @version 2018/5/9 22:05
 */
public class Main {
	public static int MoreThanHalfNum_Solution(int [] array){
		int num = array[0];
		int times = 1;
		for (int i = 1 ; i < array.length; i ++){
			if(times == 0){
				num = array[i];
				times = 1;
			} else if(array[i] == num){
				times ++;
			} else {
				times --;
			}
		}
		return checkMoreThanHelf(array,num) ? num : 0;
	}

	// 判断找到的数字 个数是否超过半数
	public static boolean checkMoreThanHelf(int[] array, int num){
		int times = 0;
		for (int n : array){
			if(n == num){
				times ++;
			}
		}
		return times > array.length >> 1;
	}

	public static void main(String[] args){
		int[] array = new int[]{1,2,2,2,2,2,3,4};
		System.out.println(MoreThanHalfNum_Solution(array));
	}
}
