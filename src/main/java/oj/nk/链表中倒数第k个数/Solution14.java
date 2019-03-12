package oj.nk.链表中倒数第k个数;

import oj.nk.ListNode;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 17:20
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
	public ListNode FindKthToTail(ListNode head, int k) {
		if(k == 0) return null;

		ListNode p1 = head;
		ListNode p2 = head;

		int i = 1;
		while (i < k && p1 != null){
			p1 = p1.next;
			i ++;
		}

		if(p1 == null) return null;

		while (p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}
}


