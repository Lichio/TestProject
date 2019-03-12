package oj.nk.两个链表的第一个公共节点;

import java.util.Stack;

/**
 * TestProject oj.nk.两个链表的第一个公共节点
 *
 * @author Lichaojie
 * @version 2018/5/14 21:15
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Main {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) return null;

		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();

		while (pHead1 != null){
			stack1.push(pHead1);
			pHead1 = pHead1.next;
		}
		while (pHead2 != null){
			stack2.push(pHead2);
			pHead2 = pHead2.next;
		}

		ListNode last = null;
		while (!stack1.isEmpty() && !stack2.isEmpty()){
			ListNode node1 = stack1.pop();
			ListNode node2 = stack2.pop();
			if(node1 == node2){
				last = node1;
			}else {
				return last;
			}
		}
		return last;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}