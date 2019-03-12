package oj.nk.数组中重复的数字;

/**
 * TestProject oj.nk.数组中重复的数字
 *
 * @author Lichaojie
 * @version 2018/5/16 21:42
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Main {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers == null || numbers.length == 0 || numbers.length == 1) return false;

		int[] ints = new int[numbers.length];
		for (int i = 0 ; i< ints.length ; i ++){
			ints[i] = 0;
		}
		for (int i = 0 ; i < numbers.length; i ++){
			ints[numbers[i]] ++;
		}
		for (int i = 0 ; i < ints.length; i ++){
			if(ints[i] > 1){
				duplication[0] = i;
				return true;
			}
		}
		return false;
	}
}
