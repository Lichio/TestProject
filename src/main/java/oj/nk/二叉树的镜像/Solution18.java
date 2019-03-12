package oj.nk.二叉树的镜像;

import oj.nk.TreeNode;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/6 18:17
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution18 {
	public void Mirror(TreeNode root) {

		//使用先序遍历（可以保证所有节点只遍历一次），对遇到的每个节点，将其左右孩子互换。
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.empty()){
			while (node != null){
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;

				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}

	}

	/**
	 * 递归实现
	 * @param root
	 */
	public void mirror(TreeNode root){
		if (root != null){
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;

			mirror(root.left);
			mirror(root.right);
		}
	}
}
