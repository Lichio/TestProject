package oj.nk.�������ڵ����ֵ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TestProject oj.nk.�������ڵ����ֵ
 *
 * @author Lichaojie
 * @version 2018/6/12 19:41
 *
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ�
 * ���ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
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
