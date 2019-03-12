package oj.nk.��������ĸ���;

/**
 * TestProject oj.nk.��������ĸ���
 *
 * @author Lichaojie
 * @version 2018/5/9 18:07
 *
 * 1.�ȸ������нڵ㣬��Ѱ��ÿ���ڵ��random��ʱ��O(n^2)���ռ�O(1)
 * 2.���ù�ϣ��洢ÿ���ڵ��random��ʱ��O(n)���ռ�O(n)
 * 3.ʱ��O(n)���ռ�O(1)  A -> A' -> B -> B' -> C -> C' -> D -> D' -> E -> E'
 */
public class Main {
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null) return null;

		//�������нڵ㣬�����ƵĽڵ����ԭ�ڵ����
		RandomListNode pNode = pHead;
		while (pNode != null){
			RandomListNode node = new RandomListNode(pNode.label);
			node.next = pNode.next;
			pNode.next = node;
			pNode = node.next;
		}

		//��ԭ�ڵ��random�򸳸��½ڵ��random��
		pNode = pHead;
		while (pNode != null){
			if(pNode.random != null){
				pNode.next.random = pNode.random.next;
			}
			pNode = pNode.next.next;
		}

		//�������½ڵ���ȡ��������µ�����
		pNode = pHead;
		RandomListNode head = pHead.next;
		RandomListNode p = head;
		pNode.next = p.next;
		pNode = pNode.next;
		while (pNode != null){
			p.next = pNode.next;
			p = p.next;
			pNode.next = p.next;
			pNode = pNode.next;
		}

		return head;
	}
}


class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}