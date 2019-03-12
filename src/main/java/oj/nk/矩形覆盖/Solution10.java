package oj.nk.���θ���;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 16:33
 *
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 *
 * ˼·��쳲���������
 */
public class Solution10 {
	public int RectCover(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;

		//�ݹ�
		//return RectCover(target - 1) + RectCover(target - 2);

		//�ǵݹ�
		int left = 1;
		int right = 2;
		int sum = 0;
		for (int i = 1; i < target - 1; i ++){
			sum = left + right;
			left = right;
			right = sum;
		}
		return sum;
	}
}
