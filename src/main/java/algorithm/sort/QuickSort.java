package algorithm.sort;

import java.util.Stack;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class QuickSort {


	/**
	 * * * * 快速排序 * * * *
	 * 快速排序采用的思想是分治思想。
	 * 快速排序是找出一个元素（理论上可以随便找一个）作为基准(pivot),然后对数组进行分区操作,使基准左边元素的值都不大于基准值,
	 * 基准右边的元素值 都不小于基准值，如此作为基准的元素调整到排序后的正确位置。
	 * 递归快速排序，将其他n-1个元素也调整到排序后的正确位置。最后每个元素都是在排序后的正确位置，排序完成。
	 *
	 * * * * 优化方式 * * * *
	 * ① 待排序数较少时（如≦47）使用插入排序
	 * ② 选取pivot的方式，可选取多个数的中位数，避免出现最坏情况
	 * ③ 与pivot相等的元素不再进入下一次划分
	 * ④
	 * * * * * * * * * * * *
	 */

	/**
	 * partition函数，将待排序元素分成两组，其中一组中每一元素的值都比另一组中每一个元素的值小
	 * @param source
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(Integer[] source,int low,int high){
		int key = source[low];//选取第一个元素为主元
		while(low < high){
			while(low < high && source[high] >= key){ //从后往前遍历，寻找比主元小的元素
				high--;
			}
			source[low] = source[high];
			while(low < high && source[low] <= key){ //从前往后遍历，寻找比主元大的元素
				low++;
			}
			source[high] = source[low];
		}
		source[low] = key;
		return low;
	}

	/**
	 * 递归快排
	 * @param source
	 * @param low
	 * @param high
	 */
	public static void quickSort1(Integer[] source,int low,int high){
		if(low < high){
			int mid = partition(source,low,high);
			quickSort1(source,low,mid - 1);
			quickSort1(source,mid + 1,high);
		}
	}

	/**
	 * 非递归快排
	 * 其实就是用栈保存每一个待排序子串的首尾元素下标，下一次while循环时取出这个范围，对这段子序列进行partition操作
	 * @param source
	 * @param low
	 * @param high
	 */
	public static void quickSort2(Integer[] source,int low,int high){
		Stack<Integer> stack = new Stack<>();
		if(low < high){
			int mid;
			stack.push(low);
			stack.push(high);
			while (!stack.isEmpty()){
				high = stack.pop();
				low = stack.pop();
				mid = partition(source,low,high);
				if(low < mid - 1){
					stack.push(low);
					stack.push(mid - 1);
				}
				if(high > mid + 1){
					stack.push(mid + 1);
					stack.push(high);
				}
			}
		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);
		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println();

		long time1 = System.nanoTime();
		quickSort2(integers,0,integers.length - 1);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
