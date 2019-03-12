package oj.nk.�ԳƵĶ�����;

import oj.nk.TreeNode;

/**
 * TestProject oj.nk.�ԳƵĶ�����
 *
 * @author Lichaojie
 * @version 2018/6/11 18:05
 *
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
