package oj.nk.对称的二叉树;

import oj.nk.TreeNode;

/**
 * TestProject oj.nk.对称的二叉树
 *
 * @author Lichaojie
 * @version 2018/6/11 18:05
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Main {
	boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetrical(pRoot,pRoot);
	}

	boolean isSymmetrical(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null){
			return false;
		}
		if(left.val != right.val){
			return false;
		}

		return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
	}
}
