package oj.nk.最小的k个数;

import java.util.ArrayList;
import java.util.List;

/**
 * TestProject oj.nk.最小的k个数
 *
 * @author Lichaojie
 * @version 2018/5/10 19:45
 */
public class Main {

	public static void main(String[] args){
		int[] input = new int[]{1,2,3,7,4,5,9,8,6};
		List<Integer> list = GetLeastNumbers_Solution(input,5);
		list.forEach(System.out::println);
	}

	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		if(k > input.length || input.length == 0 || k <= 0) return new ArrayList<>();

		int left = 0;
		int right = input.length - 1;
		int key = partition(input,left,right);
		while (key != k - 1){
			if(key > k - 1){
				right = key - 1;
				key = partition(input,left,right);
			}else {
				left = key + 1;
				key = partition(input,left,right);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(k);
		for (int i = 0 ; i < k; i ++){
			list.add(input[i]);
		}
		return list;
	}

	public static int partition(int[] source,int left,int right){
//		int key = source[left];//选取第一个元素为主元
//		int low = left;
//		int high = right;
//		while(low < high){
//			while(low < high && source[high] >= key){ //从后往前遍历，寻找比主元小的元素
//				high--;
//			}
//			source[low] = source[high];
//			while(low < high && source[low] <= key){ //从前往后遍历，寻找比主元大的元素
//				low++;
//			}
//			source[high] = source[low];
//		}
//		source[low] = key;
//		return low;
		return 0;
	}
}
