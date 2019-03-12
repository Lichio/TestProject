package course;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * TestProject course
 *
 * @author Lichaojie
 * @version 2018/3/15 20:34
 *
 * ��һ�ö������������һ���㷨�����ղ�δ�ӡ��ö�������

�����������ĸ����root���뷵�ش�ӡ������������ÿһ��һ��������д��棬
���������˳���ղ����������£���ÿһ���������Ԫ�ذ��մ����������С���֤�����С�ڵ���500��
 */
public class test1_2 {
	public static int[][] printTree(TreeNode root) {
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<TreeNode> list = new LinkedList<>();

		TreeNode last = root;
		TreeNode nlast = root;
		list.add(root);
		while (!list.isEmpty()){
			TreeNode node = list.pollFirst();
			if(node.left != null){
				list.add(node.left);
				nlast = node.left;
			}
			if(node.right != null){
				list.add(node.right);
				nlast = node.right;
			}
			arrayList.add(node.val);
			//System.out.print(node.val + " ");
			if(node == last){
				//System.out.println();
				ArrayList<Integer> tArrayList = new ArrayList<>();
				tArrayList.addAll(arrayList);
				arrayLists.add(tArrayList);
				arrayList.clear();
				last = nlast;
			}
		}

		int[][] array = new int[arrayLists.size()][];
		int i = 0;
		int j = 0;
		for (List<Integer> list1 : arrayLists){
			int tArray[] = new int[list1.size()];
			for (int n : list1){
				tArray[j ++] = n;
			}
			j = 0;
			array[i ++] = tArray;
		}
		return array;
	}

	public static TreeNode getBinaryTree(){
		List<TreeNode> list = new ArrayList<>(10);
		for (int i = 1 ; i <= 10; i ++){
			TreeNode node = new TreeNode(i);
			node.left = null;
			node.right = null;
			list.add(node);
		}

		list.get(0).left = list.get(1);
		list.get(0).right = list.get(2);

		list.get(1).left = list.get(3);
		list.get(1).right = list.get(4);

		list.get(2).left = list.get(5);
		list.get(2).right = list.get(6);

		list.get(3).right = list.get(7);

		list.get(5).left = list.get(8);
		list.get(5).right = list.get(9);

		return list.get(0);
	}

	public static void main(String[] args){
		TreeNode root = getBinaryTree();
		int[][] array = printTree(root);
		//System.out.println(array.length + " " + array[0].length);
		for (int[] n : array){
			for (int m : n){
				System.out.print(m + " ");
			}
			System.out.println();
		}
	}
}



class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}