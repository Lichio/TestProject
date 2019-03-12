package oj.nk.�ؽ�������;

import oj.nk.TreeNode;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 17:50
 *
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 *
 * ˼·��
 * ǰ������ĵ�һ���ڵ������ĸ���㣬����1�����ĸ����
 * ��������Ĺ����ǣ�1.������������2.����㣻3.��������������Ȼ1�Ǹ���㣬��ô����������������֪��4,7,2���������У�5,3,8,6����������
 * ǰ���������ĵڶ���ֵ�Ǹ������������ĸ���㣬��2������������4,7,2�ĸ���㣬����2����4,7���Ǹ����2���������е�ֵ�ˡ�ͬ��3�Ǹ������������ĸ���㣬5����3Ϊ�����������������е�ֵ��8,6���������е�ֵ
 * ����ֻ��Ҫ�ж���������4,7����������8,6��λ�þͿ����ˣ���֪��4��2������ӣ�7��4���Ҷ��ӡ�6��3���Ҷ��ӣ�8��6������ӡ�
 * ����һ���ݹ�Ĺ��̣�û����һ�Σ��ͽ���һ�ε���һ�����������������ͺ�������
 */
public class Solution4 {
	public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
		return generate(pre,0,in,0,pre.length);
	}

	//�ݹ鴴����
	public TreeNode generate(int[] pre,int prel,int[] in,int inl,int len){
		if(len == 0) return null;

		//����ǰ���������õ���ǰ���ĸ��ڵ�
		TreeNode root = new TreeNode(pre[prel]);
		int mid = 0;
		//�ҵ��ø��ڵ��������������е�λ��
		for (int i = inl ; i < inl + len; i ++){
			if(in[i] == root.val){
				mid = i - inl;
				break;
			}
		}

		//�ֱ��������������ǰ��&����������
		int len1 = mid;
		int prel1 = prel + 1;
		int inl1 = inl;

		int len2 = len - 1 - len1;
		int prel2 = prel1 + len1;
		int inl2 = inl1 + len1 + 1;

		//��������������ǰ��&����������������������
		root.left = generate(pre,prel1,in,inl1,len1);
		root.right = generate(pre,prel2,in,inl2,len2);
		return root;
	}

}
