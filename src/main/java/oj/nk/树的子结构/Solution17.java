package oj.nk.�����ӽṹ;

import oj.nk.TreeNode;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/2 9:21
 *
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 */
public class Solution17 {

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;

		if(root1 != null && root2 != null){
			if(root1.val == root2.val) result = tree1HasTree2(root1,root2);
			if(!result) result = HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
		}
		return result;
	}

	boolean tree1HasTree2(TreeNode root1,TreeNode root2){
		if(root2 == null) return true;
		if(root1 == null) return false;

		if(root1.val != root2.val) return false;

		return tree1HasTree2(root1.left,root2.left) && tree1HasTree2(root1.right,root2.right);
	}

	public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null) return false;

		//���������root1�����������ӽڵ�Ϊ������������root2�����жϱȽ�
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root1;
		//����whileѭ��Ϊ������root1�Ĺ���
		while (node != null || !stack.empty()){
			while (node != null){
				stack.push(node);
				//preorder�ж�root2�Ƿ�Ϊroot1�������ӽṹ
				if(preorder(node,root2)) return true;
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}

		return false;
	}

	public boolean preorder(TreeNode root1,TreeNode root2){
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		TreeNode node1 = root1;
		TreeNode node2 = root2;

		//���α�����root2�������root1������ͬ�ṹ����root2��root1���ӽṹ
		//root1����root2��ͬ��˳�������������������ֽṹ��ƥ�䣬�򷵻�false
		while (node2 != null || !stack2.empty()){
			while (node2 != null){
				//�������ṹ��ƥ������
				if(node1 == null || node1.val != node2.val) return false;
				stack1.push(node1);
				stack2.push(node2);
				node1 = node1.left;
				node2 = node2.left;
			}
			node1 = stack1.pop();
			node1 = node1.right;
			node2 = stack2.pop();
			node2 = node2.right;
		}
		return true;
	}

}
