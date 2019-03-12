package oj.nk.树的子结构;

import oj.nk.TreeNode;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/2 9:21
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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

		//先序遍历树root1，将所有以子节点为根的子树与树root2进行判断比较
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root1;
		//两个while循环为遍历树root1的过程
		while (node != null || !stack.empty()){
			while (node != null){
				stack.push(node);
				//preorder判断root2是否为root1子树的子结构
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

		//依次遍历树root2，如果树root1中有相同结构，则root2是root1的子结构
		//root1以与root2相同的顺序遍历，过程中如果出现结构不匹配，则返回false
		while (node2 != null || !stack2.empty()){
			while (node2 != null){
				//两个树结构不匹配的情况
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
