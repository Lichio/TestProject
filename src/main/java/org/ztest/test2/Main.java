package org.ztest.test2;

import oj.nk.TreeNode;

import java.util.*;

/**
 * TestProject org.test.test10
 *
 * @author Lichaojie
 * @version 2018/6/26 10:53
 */
public class Main {
	public static void main(String[] args){
		int[] pre = {1,2,4,3,5,6};
		int[] in = {4,2,1,5,3,6};
		bfs(reConstructBinaryTree(pre,in));
	}

	private static HashMap<Integer, Integer> map=new HashMap<>();
	private static TreeNode root=null;
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in)
	{
		for(int i=0;i<in.length;i++) {
			map.put(in[i], i);//根据数据在序列中的位置判断在左还是右。
		}
		if(root==null) {
			root=new TreeNode(pre[0]);
		}

		for(int i=1;i<pre.length;i++)
		{
			TreeNode current=root;
			int val=pre[i];
			while(true) {
				if(map.get(val)<map.get(current.val)) {
					if(current.left!=null) {
						current=current.left;
					}
					else {
						current.left=new TreeNode(val);
						System.out.println(val);
						break;
					}
				}
				else {
					if(current.right!=null) {
						current=current.right;
					}
					else {
						current.right=new TreeNode(val);
						System.out.println(val);
						break;
					}
				}
			}
		}
		return root;
	}

	public static void bfs(TreeNode root){
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()){
			TreeNode node = list.removeFirst();
			if(node.left != null) list.addLast(node.left);
			if(node.right != null) list.addLast(node.right);
			System.out.print(node.val + " ");
		}
	}
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
