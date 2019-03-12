package oj.nk.二叉树的下一个节点;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TestProject oj.nk.二叉树的下一个节点
 *
 * @author Lichaojie
 * @version 2018/6/11 17:28
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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