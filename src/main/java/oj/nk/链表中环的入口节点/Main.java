package oj.nk.�����л�����ڽڵ�;

import oj.nk.ListNode;

import java.util.List;

/**
 * TestProject oj.nk.�����л�����ڽڵ�
 *
 * @author Lichaojie
 * @version 2018/6/11 17:08
 *
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
 */
public class Main {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		//����Ϊ��
		if(pHead == null) return null;

		ListNode p1 = pHead;
		ListNode p2 = pHead;

		do {
			//Ϊ���ж������Ƿ��л����������ĳ���ڵ��next��Ϊnull��������û�л�
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
