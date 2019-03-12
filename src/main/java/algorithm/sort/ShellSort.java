package algorithm.sort;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class ShellSort {

	/**
	 * * * * 希尔排序 * * * *
	 * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。所有距离为d1的倍数的记录放在同一个组中。
	 * 先在各组内进行*直接插入排序*；然后，取第二个增量d2<d1重复上述的分组和排序，
	 * 直至所取的增量  =1(  <  …<d2<d1)，即所有记录放在同一组中进行*直接插入排序*为止
	 *
	 * 重点在步长的选择
	 */
	private static void shellSort(Integer[] source){
		int length = source.length;
		for (int width = length / 2; width >= 1; width = width / 2){
			for (int i = width; i < length; i ++){
				int data = source[i];
				int j = i - width;
				while(j >= 0 && data < source[j]){
					source[j + width] = source[j];
					j -= width;
				}
				source[j + width] = data;
			}
		}

	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		shellSort(integers);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
