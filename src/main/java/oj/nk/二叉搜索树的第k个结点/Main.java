package oj.nk.�����������ĵ�k�����;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * TestProject oj.nk.�����������ĵ�k�����
 *
 * @author Lichaojie
 * @version 2018/6/11 21:18
 *
 * ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬
 *             5
 *            / \
 *           3   7
 *          /\  /\
 *         2 4 6 8
 * �У��������ֵ��С˳�����������ֵΪ4��
 *
 * ˼·���������ȡ��k���ڵ�
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
