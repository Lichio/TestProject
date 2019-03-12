package oj.nk.复杂链表的复制;

/**
 * TestProject oj.nk.复杂链表的复制
 *
 * @author Lichaojie
 * @version 2018/5/9 18:07
 *
 * 1.先复制所有节点，再寻找每个节点的random域，时间O(n^2)，空间O(1)
 * 2.利用哈希表存储每个节点的random域，时间O(n)，空间O(n)
 * 3.时间O(n)，空间O(1)  A -> A' -> B -> B' -> C -> C' -> D -> D' -> E -> E'
 */
public class Main {
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null) return null;

		//复制所有节点，将复制的节点接在原节点后面
		RandomListNode pNode = pHead;
		while (pNode != null){
			RandomListNode node = new RandomListNode(pNode.label);
			node.next = pNode.next;
			pNode.next = node;
			pNode = node.next;
		}

		//将原节点的random域赋给新节点的random域
		pNode = pHead;
		while (pNode != null){
			if(pNode.random != null){
				pNode.next.random = pNode.random.next;
			}
			pNode = pNode.next.next;
		}

		//将所有新节点提取出来组成新的链表
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