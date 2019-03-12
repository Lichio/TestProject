package oj.nk.平衡二叉树;

/**
 * TestProject oj.nk.平衡二叉树
 *
 * @author Lichaojie
 * @version 2018/5/15 20:25
 */
public class Main {
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) {
			return true;
		}

		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		if(Math.abs(left - right) > 1) return false;

		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

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