package oj.nk.二叉树的深度;

/**
 * TestProject oj.nk.二叉树的深度
 *
 * @author Lichaojie
 * @version 2018/5/15 20:21
 */
public class Main {
	public int TreeDepth(TreeNode root) {
		if(root == null){
			return 0;
		}

		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		return left > right ? left + 1: right + 1;
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