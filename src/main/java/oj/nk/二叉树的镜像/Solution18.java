package oj.nk.�������ľ���;

import oj.nk.TreeNode;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/6 18:17
 *
 * ���������Ķ�����������任ΪԴ�������ľ���
 */
public class Solution18 {
	public void Mirror(TreeNode root) {

		//ʹ��������������Ա�֤���нڵ�ֻ����һ�Σ�����������ÿ���ڵ㣬�������Һ��ӻ�����
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
	 * �ݹ�ʵ��
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
