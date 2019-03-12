package oj.nk.从尾到头打印链表;

import oj.nk.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 17:33
 *
 * 输入一个链表，从尾到头打印链表每个节点的值。
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
