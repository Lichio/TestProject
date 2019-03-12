package algorithm.sort;

/**
 * TestProject algorithm.sort
 *
 * @author Lichaojie
 * @version 2018/3/26 19:31
 *
 * 找出待排序的数组中最大和最小的元素
 * 统计数组中每个值为i的元素出现的次数，存入数组C 的第i项
 * 对所有的计数累加（从C 中的第一个元素开始，每一项和前一项相加）
 * 反向填充目标数组：将每个元素i放在新数组的第C[i]项，每放一个元素就将C[i]减去1
 */
public class CountingSort {
	public int[] countingSort(int[] A, int n) {
		if(n == 0) return new int[0];

		int min;
		int max;

		min = max = A[0];
		for (int i = 1; i < n; i ++){
			if(min > A[i]) min = A[i];
			if(max < A[i]) max = A[i];
		}

		int[] c = new int[max - min + 1];

		for (int m : A){
			c[m - min] = c[m - min] + 1;
		}

		for (int i = 1;i < c.length; i ++){
			c[i] = c[i] + c[i - 1];
		}

		int[] result = new int[n];

		for (int m : A){
			result[c[m - min] - 1] = m;
			c[m - min] = c[m - min] - 1;
		}

		return result;
	}
}
