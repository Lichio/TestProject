package oj.nk.矩形覆盖;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 16:33
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路：斐波拉契数列
 */
public class Solution10 {
	public int RectCover(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;

		//递归
		//return RectCover(target - 1) + RectCover(target - 2);

		//非递归
		int left = 1;
		int right = 2;
		int sum = 0;
		for (int i = 1; i < target - 1; i ++){
			sum = left + right;
			left = right;
			right = sum;
		}
		return sum;
	}
}
