package oj.nk.滑动窗口的最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TestProject oj.nk.滑动窗口的最大值
 *
 * @author Lichaojie
 * @version 2018/6/12 19:41
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Main {
	public static ArrayList<Integer> maxInWindows(int [] num, int size) {
		LinkedList<Integer> list = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();

		if(size == 0) return result;

		for (int i = 0 ; i < num.length; i ++){
			while (list.size() > 0 && num[i] >= num[list.getLast()]){
				list.removeLast();
			}
			list.addLast(i);
			if(i - list.getFirst() > size - 1){
				list.removeFirst();
			}
			if(i >= size - 1){
				result.add(num[list.getFirst()]);
			}
		}
		return result;
	}

	public static void main(String[] args){
		int[] num = {2,3,4,2,6,2,5,1};
		List list = maxInWindows(num,3);
		list.forEach(System.out::println);
	}
}
