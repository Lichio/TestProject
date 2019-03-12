package oj.nk.��̬��̨��;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:46
 *
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 *
 * ˼·��f(n) = f(n-1) + f(n-2) + �� + f(2) + f(1) + 1
 */
public class Solution9 {
	public int JumpFloorII(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;

		int sum = 0;
		for (int i = target - 1; i > 0; i --){
			sum += JumpFloorII(i);
		}
		sum += 1;

		return sum;
	}
}
