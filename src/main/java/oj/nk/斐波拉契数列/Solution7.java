package oj.nk.斐波拉契数列;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:29
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Solution7 {
	public int Fibonacci(int n) {
		if(n == 1 || n == 2) return 1;

		//递归
		//return Fibonacci(n - 1) + Fibonacci(n - 2);

		//非递归
		int left = 1;
		int right = 1;
		int sum = 0;
		for (int i = 1; i < n - 1; i ++){
			sum = left + right;
			left = right;
			right = sum;
		}
		return sum;
	}
}
