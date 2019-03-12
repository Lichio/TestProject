package oj.nk.删除链表中重复的节点;

import oj.nk.ListNode;

import java.util.List;

/**
 * TestProject oj.nk.删除链表中重复的节点
 *
 * @author Lichaojie
 * @version 2018/6/13 12:01
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
