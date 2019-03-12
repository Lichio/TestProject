package oj.nk.��ת����;

import oj.nk.ListNode;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 18:30
 *
 * ����һ��������ת�����������������Ԫ�ء�
 */
public class Solution15 {
	public ListNode ReverseList(ListNode head) {
		return reverse1(head);
	}

	/**
	 * �ݹ�ʵ��
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
	 * �ǵݹ�ʵ��
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
