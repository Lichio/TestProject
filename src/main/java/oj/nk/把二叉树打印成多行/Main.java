package oj.nk.�Ѷ�������ӡ�ɶ���;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * TestProject oj.nk.�Ѷ�������ӡ�ɶ���
 *
 * @author Lichaojie
 * @version 2018/6/11 20:37
 *
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
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
				//��ǰ�ڵ�Ϊ��һ�����ҽڵ�ʱ�����������½���Ľڵ�Ϊ��һ�����ҽڵ�
				if(!treeNodes.isEmpty()){
					lastLayer = treeNodes.getLast();
				}
			}
		}

		return lists;
	}
}
