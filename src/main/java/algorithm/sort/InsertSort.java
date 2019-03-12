package algorithm.sort;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class InsertSort {

	/**
	 * * * * 二分插入排序 * * * *
	 * 在寻找插入位置时使用二分查找方法
	 */

	/**
	 * * * * 直接插入排序 * * * *
	 * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，
	 * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
	 * 插入算法把要排序的数组分成两部分：第一部分包含了这个数组的所有元素，但将最后一个元素除外（让数组多一个空间才有插入的位置），
	 * 而第二部分就只包含这一个元素（即待插入元素）。在第一部分排序完成后，再将这个最后元素插入到已排好序的第一部分中。
	 */
	public static void insertSort(Integer[] source){
		int length = source.length;

		for (int i = 1; i < length; i ++){    //i记录未排序的元素
			int data = source[i];
			int j = i - 1;                    //j指向已排好序序列的末尾
			while (j >=0 && data < source[j]){//从后往前比较
				source[j + 1] = source[j];
				j --;
			}
			source[j + 1] = data;
		}
	}


	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		insertSort(integers);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
