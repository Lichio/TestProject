package oj.nk.�������е���λ��;

import oj.nk.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TestProject oj.nk.�������е���λ��
 *
 * @author Lichaojie
 * @version 2018/6/11 21:27
 *
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
public class Main {
	List<Integer> list = new ArrayList<>();

	public void Insert(Integer num) {
		list.add(num);
		int i = list.size() - 1;
		while (i - 1 >= 0 && num < list.get(i - 1)){
			list.set(i,list.get(i - 1));
			i --;
		}
		list.set(i,num);
	}

	public Double GetMedian() {
		if((list.size() & 1) == 1){
			return list.get((list.size() - 1) / 2).doubleValue();
		}else {
			int n1 = list.get(list.size() / 2 - 1);
			int n2 = list.get(list.size() / 2);
			return (n1 + n2) / 2.0;
		}
	}

}
