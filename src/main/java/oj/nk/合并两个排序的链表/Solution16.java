package oj.nk.�ϲ��������������;

import oj.nk.ListNode;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 18:46
 *
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class Solution16 {

	/**
	 * �ǵݹ�ʵ��
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode Merge1(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;

		ListNode root = null;
		ListNode head = null;

		//�ҵ���һ���ڵ�
		if(list1.val < list2.val){
			root = list1;
			list1 = list1.next;
		}else {
			root = list2;
			list2 = list2.next;
		}
		head = root;

		//�ϲ�����
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
	 * �ݹ�ʵ��
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
