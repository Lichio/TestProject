package algorithm.sort;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class SelectSort {

	/**
	 * 选择排序（Selection sort）是一种简单直观的排序算法。
	 * 它的工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
	 * 选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）
	 */
	public static void selectSort(Integer[] source){
		int length = source.length;

		for (int i = 0; i < length; i ++){
			int index = i;
			for (int j = i; j < length; j ++){
				if(source[index] - source[j] > 0){
					index = j;
				}
			}
			int temp = source[i];
			source[i] = source[index];
			source[index] = temp;
		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		selectSort(integers);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
