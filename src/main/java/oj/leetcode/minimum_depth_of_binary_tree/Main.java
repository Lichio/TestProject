package oj.leetcode.minimum_depth_of_binary_tree;

import oj.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * TestProject oj.leetcode.minimumDepthOfBinaryTree
 *
 * @author Lichaojie
 * @version 2018/6/13 15:24
 *
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the
 * shortest path from the root node down to the nearest leaf node.
 */
public class Main {
	public int run(TreeNode root) {
		LinkedList<TreeNode> treeNodes = new LinkedList<>();

		if(root == null) return 0;

		int count = 0;
		TreeNode lastLayer = root;
		treeNodes.addLast(root);
		while (!treeNodes.isEmpty()){
			TreeNode node = treeNodes.pollFirst();
			if(node.left == null && node.right == null){
				return count + 1;
			}
			if(node.left != null){
				treeNodes.addLast(node.left);
			}
			if(node.right != null){
				treeNodes.addLast(node.right);
			}

			if(node == lastLayer){
				count ++;
				if(!treeNodes.isEmpty()){
					lastLayer = treeNodes.getLast();
				}
			}
		}
		return count + 1;
	}
}
