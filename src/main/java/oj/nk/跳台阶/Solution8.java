package oj.nk.跳台阶;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:39
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 思路：斐波拉契数列
 */
public class Solution8 {
	public int JumpFloor(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;

		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}
}
