package algorithm.sort;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * algorithm.sort
 * Created on 2017/11/10
 *
 * @author Lichaojie
 */
public class RadixSort {


	/**
	 * 基数排序，将待排序元素按各数位上的数字进行排序，从低数位到高数位
	 *
	 * 1.按个位上的数字放入桶中，将桶里的数字按桶的顺序依次倒出
	 * 2.按十位上的数字放入桶中，将桶里的数字按桶的顺序依次倒出
	 * ……
	 * n.排序完成后，最后一次倒出的序列就是有序的
	 *
	 * @param source
	 */
	public static void radixSort(Integer[] source){
		List<Integer>[] order = new ArrayList[10];
		for (int x = 0 ; x < order.length; x ++){
			order[x] = new ArrayList<>();
		}

		int n = 1;//从个位数开始
		while (true){
			//根据当前位数的数值分配到不同的桶中
			for (int i = 0; i < source.length; i ++){
				int remainder = (source[i] / n) % 10;
				order[remainder].add(source[i]);
			}

			//将这一次的排序结果放回原数组
			int index = 0;
			for (int j = 0; j < order.length; j ++){
				for (Integer integer : order[j]){
					source[index ++] = integer;
				}
			}

			//往前取更高位数的值
			n *= 10;

			if(order[0].size() == source.length){
				break;
			}

			for (List list : order){
				list.clear();
			}
		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		radixSort(integers);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}
}
