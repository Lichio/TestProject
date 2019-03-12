package oj.nk.���л�������;

import oj.nk.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * TestProject oj.nk.���л�������
 *
 * @author Lichaojie
 * @version 2018/6/11 20:39
 *
 * ��ʵ�������������ֱ��������л��ͷ����л�������
 */
public class Main {
	String Serialize(TreeNode root) {
		if(root == null) return null;

		LinkedList<TreeNode> queue = new LinkedList<>();
		ArrayList<TreeNode> list = new ArrayList<>();
		queue.addLast(root);
		while (!queue.isEmpty()){
			TreeNode node = queue.pollFirst();
			if(node != null){
				queue.addLast(node.left);
				queue.addLast(node.right);
			}
			list.add(node);
		}
		StringBuilder sb = new StringBuilder();
		for (TreeNode node : list){
			if(node != null){
				sb.append(node.val);
			}else {
				sb.append("#");
			}
			sb.append("!");
		}
		return sb.toString();
	}

	TreeNode Deserialize(String str) {
		if(str == null) return null;

		ArrayList<TreeNode> list = new ArrayList<>();
		String[] strings = str.split("!");
		for (String s : strings){
			if("#".equals(s)){
				list.add(null);
			}else {
				TreeNode node = new TreeNode(Integer.parseInt(s));
				list.add(node);
			}
		}

		int p1,p2;
		p1 = 0;
		p2 = 1;
		while (p2 < list.size()){
			TreeNode node = list.get(p1);
			if(node != null){
				node.left = list.get(p2 ++);
				node.right = list.get(p2 ++);
			}
			p1 ++;
		}

		return list.get(0);
	}
}
