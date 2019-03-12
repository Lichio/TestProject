package oj.leetcode.insertion_sort_list;

import oj.leetcode.ListNode;

/**
 * TestProject oj.leetcode.insertion_sort_list
 *
 * @author Lichaojie
 * @version 2018/9/11 15:55
 *
 * Sort a linked list using insertion sort.
 */
public class Main {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode r = head.next;
		head.next = null;
		while (r != null) {
			ListNode q = head;
			ListNode p = null;
			while (q != null && q.val < r.val) {
				p = q;
				q = q.next;
			}
			ListNode t = r.next;
			if(q == head) {
				r.next = head;
				head = r;
			} else {
				p.next = r;
				r.next = q;
			}
			r = t;
		}
		return head;
	}
}
