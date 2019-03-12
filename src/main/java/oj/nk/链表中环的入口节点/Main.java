package oj.nk.链表中环的入口节点;

import oj.nk.ListNode;

import java.util.List;

/**
 * TestProject oj.nk.链表中环的入口节点
 *
 * @author Lichaojie
 * @version 2018/6/11 17:08
 *
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Main {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		//链表为空
		if(pHead == null) return null;

		ListNode p1 = pHead;
		ListNode p2 = pHead;

		do {
			//为了判断链表是否有环，如果出现某个节点的next域为null，则链表没有环
			if(p1 == null) return null;
			p1 = p1.next;
			if(p2 == null || p2.next == null) return null;
			p2 = p2.next.next;
		}while (p1 != p2);

		p1 = pHead;
		while (p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}
}
