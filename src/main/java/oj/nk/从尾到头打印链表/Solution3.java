package oj.nk.��β��ͷ��ӡ����;

import oj.nk.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 17:33
 *
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */
public class Solution3 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<>();
		if(listNode == null){
			return list;
		}else {
			list.addAll(printListFromTailToHead(listNode.next));
			list.add(listNode.val);
		}
		return list;
	}


}
