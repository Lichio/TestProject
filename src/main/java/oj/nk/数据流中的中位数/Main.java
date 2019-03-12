package oj.nk.数据流中的中位数;

import oj.nk.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TestProject oj.nk.数据流中的中位数
 *
 * @author Lichaojie
 * @version 2018/6/11 21:27
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
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
