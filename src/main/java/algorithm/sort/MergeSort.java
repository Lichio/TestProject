package algorithm.sort;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class MergeSort {


	/**
	 * * * * 归并排序 * * * *
	 * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
	 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
	 *
	 * 归并过程为：比较a[i]和b[j]的大小，若a[i]≤b[j]，则将第一个有序表中的元素a[i]复制到r[k]中，并令i和k分别加上1；
	 * 否则将第二个有序表中的元素b[j]复制到r[k]中，并令j和k分别加上1，如此循环下去，直到其中一个有序表取完，
	 * 然后再将另一个有序表中剩余的元素复制到r中从下标k到下标t的单元。
	 * 归并排序的算法我们通常用递归实现，先把待排序区间[s,t]以中点二分，接着把左边子区间排序，再把右边子区间排序，
	 * 最后把左区间和右区间用一次归并操作合并成有序的区间[s,t]
	 *
	 * 迭代法：将序列每相邻两个元素进行归并（此时原序列分为n/2个序列），然后再将每四个元素进行归并（此时原序列分为n/2个序列），
	 * 依次归并，直到所有元素得到排序
	 */

	/**
	 * merge函数，将两个有序的元素序列合成一个有序的元素序列
	 * @param array
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(Integer[] array, int low, int mid, int high) {
		int i = low; // i是第一段序列的下标
		int j = mid + 1; // j是第二段序列的下标
		int k = 0; // k是临时存放合并序列的下标
		int[] array2 = new int[high - low + 1]; // array2是临时合并序列

		// 扫描第一段和第二段序列，直到有一个扫描结束
		while (i <= mid && j <= high) {
			// 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
			if (array[i] <= array[j]) {
				array2[k ++] = array[i ++];
			} else {
				array2[k ++] = array[j ++];
			}
		}

		// 若第一段序列还没扫描完，将其全部复制到合并序列
		while (i <= mid) {
			array2[k ++] = array[i ++];
		}

		// 若第二段序列还没扫描完，将其全部复制到合并序列
		while (j <= high) {
			array2[k ++] = array[j ++];
		}

		// 将合并序列复制到原始序列中
		for (k = 0, i = low; i <= high; i++, k++) {
			array[i] = array2[k];
		}
	}

	/**
	 * 递归 归并
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void mergeSort1(Integer[] array,int low,int high){
		if(low < high){
			int q = (low + high) / 2;
			mergeSort1(array,low,q);
			mergeSort1(array,q+1,high);
			merge(array,low,q,high);
		}
	}

	/**
	 * 非递归 归并
	 * 将数组分成长度为length的多个段，利用merge函数合并，length依次为2,4,8,……
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void mergeSort2(Integer[] array,int low,int high){
		if(low < high){
			int length = 2;
			int l;
			while (length <= high - low + 1){
				l = low;
				while (l < high && l + length - 1 < high){
					merge(array,l,l + (length - 2) / 2,l + length - 1);
					l += length;
				}
				//处理末尾不够length长度的段
				merge(array,l,l + (length - 2) / 2,high);
				length *= 2;
			}
			//此时整个数组为两个排好序的段，最后对这两个段进行合并
			merge(array,low,low + (length - 2) / 2, high);
		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		mergeSort2(integers,0,integers.length - 1);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
