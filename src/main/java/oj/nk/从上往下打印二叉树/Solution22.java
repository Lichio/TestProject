package oj.nk.从上往下打印二叉树;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/8 21:12
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> treeList = new LinkedList<>();

		if(root == null) return list;

		treeList.push(root);
		while (!treeList.isEmpty()){
			TreeNode node = treeList.pollFirst();
			list.add(node.val);
			if(node.left != null){
				treeList.add(node.left);
			}
			if(node.right != null){
				treeList.add(node.right);
			}
		}
		return list;
	}
}
