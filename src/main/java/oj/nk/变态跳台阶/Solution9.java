package oj.nk.变态跳台阶;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:46
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：f(n) = f(n-1) + f(n-2) + … + f(2) + f(1) + 1
 */
public class Solution9 {
	public int JumpFloorII(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;

		int sum = 0;
		for (int i = target - 1; i > 0; i --){
			sum += JumpFloorII(i);
		}
		sum += 1;

		return sum;
	}
}
