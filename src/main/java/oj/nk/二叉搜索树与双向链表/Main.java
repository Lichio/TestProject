package oj.nk.二叉搜索树与双向链表;

import java.util.ArrayList;
import java.util.List;

/**
 * TestProject oj.nk.二叉搜索树与双向链表
 *
 * @author Lichaojie
 * @version 2018/5/9 20:52
 */
public class Main {
	private List<TreeNode> list = new ArrayList<>();

	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) return null;

		change(pRootOfTree);
		for (int i = 0 ; i < list.size(); i ++){
			TreeNode lNode = i - 1 < 0 ? null : list.get(i - 1);
			TreeNode rNode = i + 1 >= list.size() ? null : list.get(i + 1);
			list.get(i).left = lNode;
			list.get(i).right = rNode;
		}
		return list.get(0);
	}

	public void change(TreeNode root){
		if(root != null){
			change(root.left);
			list.add(root);
			change(root.right);
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