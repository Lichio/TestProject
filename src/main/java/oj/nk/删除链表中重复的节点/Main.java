package oj.nk.ɾ���������ظ��Ľڵ�;

import oj.nk.ListNode;

import java.util.List;

/**
 * TestProject oj.nk.ɾ���������ظ��Ľڵ�
 *
 * @author Lichaojie
 * @version 2018/6/13 12:01
 *
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */
public class Main {
	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null) return null;

		ListNode head = null;
		ListNode pNode = head;
		ListNode node = pHead;
		while (node != null){
			if(node.next != null && node.next.val == node.val){
				int val = node.val;
				while (node != null && node.val == val){
					node = node.next;
				}
			}else {
				if(pNode == null){
					pNode = node;
					head = pNode;
				}else {
					pNode.next = node;
					pNode = pNode.next;
				}
				node = node.next;
			}
		}
		if(pNode != null) pNode.next = null;
		return head;
	}
}
