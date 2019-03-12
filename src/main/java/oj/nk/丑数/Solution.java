package oj.nk.丑数;

/**
 * TestProject oj.nk.丑数
 *
 * @author Lichaojie
 * @version 2018/4/12 21:10
 *
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution {
	public int GetUglyNumber_Solution(int index) {
		if(index == 0) return 0;

		// 存储已找到的丑树，有序
		int[] array = new int[index];

		array[0] = 1;

		int cur = 1,t2 = 0,t3 = 0,t5 = 0;

		while (cur < index){
			// 计算：所有已知的丑数依次乘2，结果中第一个比当前最大丑树大的丑数
			while (t2 < cur - 1 && 2 * array[t2] <= array[cur - 1]){
				t2 ++;
			}
			while (t3 < cur - 1 && 3 * array[t3] <= array[cur - 1]){
				t3 ++;
			}
			while (t5 < cur - 1 && 5 * array[t5] <= array[cur - 1]){
				t5 ++;
			}

			// 新的丑数：所有已知丑数乘2、3、5的结果中最小的数
			array[cur ++] = Math.min(2 * array[t2],Math.min(3 * array[t3],5 * array[t5]));
		}

		return array[index - 1];

	}
}
