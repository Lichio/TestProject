package oj.nk.��̨��;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:39
 *
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 *
 * ˼·��쳲���������
 */
public class Solution8 {
	public int JumpFloor(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;

		return JumpFloor(target - 1) + JumpFloor(target - 2);
	}
}
