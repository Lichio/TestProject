package oj.nk.把二叉树打印成多行;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * TestProject oj.nk.把二叉树打印成多行
 *
 * @author Lichaojie
 * @version 2018/6/11 20:37
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Main {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		LinkedList<TreeNode> treeNodes = new LinkedList<>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();

		if(pRoot == null) return lists;

		TreeNode lastLayer = pRoot;
		treeNodes.addLast(pRoot);
		while (!treeNodes.isEmpty()){
			TreeNode node = treeNodes.pollFirst();
			list.add(node.val);
			if(node.left != null){
				treeNodes.addLast(node.left);
			}
			if(node.right != null){
				treeNodes.addLast(node.right);
			}

			if(node == lastLayer){
				ArrayList<Integer> tList = new ArrayList<>();
				tList.addAll(list);
				lists.add(tList);
				list.clear();
				//当前节点为上一层最右节点时，队列中最新进入的节点为下一层最右节点
				if(!treeNodes.isEmpty()){
					lastLayer = treeNodes.getLast();
				}
			}
		}

		return lists;
	}
}
