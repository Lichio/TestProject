package oj.nk.合并两个排序的链表;

import oj.nk.ListNode;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 18:46
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {

	/**
	 * 非递归实现
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode Merge1(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;

		ListNode root = null;
		ListNode head = null;

		//找到第一个节点
		if(list1.val < list2.val){
			root = list1;
			list1 = list1.next;
		}else {
			root = list2;
			list2 = list2.next;
		}
		head = root;

		//合并过程
		while (list1 != null && list2 != null){
			if(list1.val < list2.val){
				head.next = list1;
				list1 = list1.next;
			}else {
				head.next = list2;
				list2 = list2.next;
			}
			head = head.next;
		}
		if(list1 != null) head.next = list1;
		if(list2 != null) head.next = list2;

		return root;
	}


	/**
	 * 递归实现
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode Merge2(ListNode list1, ListNode list2){
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		ListNode root = null;
		if(list1.val < list2.val){
			root = list1;
			root.next = Merge2(list1.next,list2);
		}else {
			root = list2;
			root.next = Merge2(list1,list2.next);
		}

		return root;
	}
}
