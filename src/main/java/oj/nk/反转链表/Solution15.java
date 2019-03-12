package oj.nk.反转链表;

import oj.nk.ListNode;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 18:30
 *
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Solution15 {
	public ListNode ReverseList(ListNode head) {
		return reverse1(head);
	}

	/**
	 * 递归实现
	 * @param head
	 * @return
	 */
	public ListNode reverse2(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode p = reverse2(head.next);
		head.next.next = head;
		head.next = null;

		return p;
	}

	/**
	 * 非递归实现
	 * @param head
	 * @return
	 */
	public ListNode reverse1(ListNode head){
		if(head == null || head.next == null){
			return head;
		}

		ListNode lp = null;
		ListNode rp = head;

		while (rp != null){
			ListNode tp = rp.next;
			rp.next = lp;
			lp = rp;
			rp = tp;
		}

		return lp;
	}
}
