package oj.nk.����������һ���ڵ�;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TestProject oj.nk.����������һ���ڵ�
 *
 * @author Lichaojie
 * @version 2018/6/11 17:28
 *
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */
public class Main {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) return null;
		TreeLinkNode root = pNode;
		while (root.next != null){
			root = root.next;
		}

		List<TreeLinkNode> linkNodes = new ArrayList<>();
		Stack<TreeLinkNode> stack = new Stack<>();
		TreeLinkNode p = root;
		while (p != null || !stack.isEmpty()){
			while (p != null){
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			linkNodes.add(p);
			p = p.right;
		}
		for (int i = 0 ; i < linkNodes.size(); i ++){
			if(linkNodes.get(i) == pNode && i + 1 < linkNodes.size()){
				return linkNodes.get(i + 1);
			}
		}
		return null;
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}