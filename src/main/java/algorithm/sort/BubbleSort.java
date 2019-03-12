package algorithm.sort;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class BubbleSort {

	public static void bubbleSort1(Integer[] source){
		for (int i = 0; i < source.length; i ++){
			for (int j = 0; j < source.length - i - 1; j ++){
				if(source[j] - source[j + 1] > 0){
					int temp = source[j];
					source[j] = source[j + 1];
					source[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 冒泡排序使用双重循环实现，外层循环记录比较趟数，内层循环记录每趟比较次数。
	 * 如果某一趟没有发生数据交换，说明此时待排序序列已经是有序的了，算法停止。
	 * 我们需要一个标志位来判断条件是否成立，如果成立则直接退出。
	 * @param source
	 */
	public static void bubbleSort2(Integer[] source){
		int k;
		//记录一次循环中数据交换的最右位置，该位置右边的数据时有序的，下一步不需要排序；
		//若该值为0，表示当前循环没有发生数据交换，说明整个数组有序，不需要进行后续排序操作
		int flag = source.length;
		while (flag > 0){
			k = flag;
			flag = 0;
			for (int i = 0; i < k - 1;i ++){
				if(source[i] > source[i + 1]){
					int temp = source[i];
					source[i] = source[i + 1];
					source[i + 1] = temp;
					flag = i + 1;
				}
			}
		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		bubbleSort1(integers);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
