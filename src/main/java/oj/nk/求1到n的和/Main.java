package oj.nk.��1��n�ĺ�;

/**
 * TestProject oj.nk.��1��n�ĺ�
 *
 * @author Lichaojie
 * @version 2018/5/15 22:12
 *
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 *
 * �� ʹ�õݹ�
 * ��
 * ��
 */
public class Main {
	public int Sum_Solution(int n) {
		if(n == 1) return 1;
		return n + Sum_Solution(n - 1);
	}
}
