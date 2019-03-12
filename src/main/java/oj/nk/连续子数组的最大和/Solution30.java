package oj.nk.连续子数组的最大和;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/4/11 21:27
 */
public class Solution30 {
	public int FindGreatestSumOfSubArray(int[] array) {
		int[] dp = new int[array.length];

		dp[0] = array[0];
		for (int i = 1; i < array.length; i ++){
			dp[i] = Math.max(dp[i - 1] + array[i],array[i]);
		}

		int max = dp[0];
		for (int n : dp){
			if(max < n) max = n;
		}

		return max;
	}
}
