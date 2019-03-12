package oj.nk.二叉搜索树的第k个结点;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * TestProject oj.nk.二叉搜索树的第k个结点
 *
 * @author Lichaojie
 * @version 2018/6/11 21:18
 *
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如，
 *             5
 *            / \
 *           3   7
 *          /\  /\
 *         2 4 6 8
 * 中，按结点数值大小顺序第三个结点的值为4。
 *
 * 思路：中序遍历取第k个节点
 */
public class Main {
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot == null) return null;

		int num = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = pRoot;

		while (node != null || !stack.isEmpty()){
			while (node != null){
				stack.add(node);
				node = node.left;
			}
			node = stack.pop();
			num ++;
			if(num == k){
				return node;
			}
			node = node.right;
		}
		return null;
	}
}
