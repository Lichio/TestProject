package oj.nk.��֮����˳���ӡ������;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * TestProject oj.nk.��֮����˳���ӡ������
 *
 * @author Lichaojie
 * @version 2018/6/11 18:30
 *
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 * �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class Main {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
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
				if(!treeNodes.isEmpty()){
					lastLayer = treeNodes.getLast();
				}
			}
		}

		for (int i = 0; i < lists.size(); i ++){
			if( (i & 1) == 1){
				Collections.reverse(lists.get(i));
			}
		}

		return lists;
	}

	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		list2.add(5);
		lists.add(list1);
		lists.add(list2);
		System.out.println(lists);
		Collections.reverse(lists.get(1));
		System.out.println(lists);
	}
}
