package oj.nk.��������˳��ʹ����λ��ż��ǰ��;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 17:01
 *
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 *
 * ˼·���ο��ȶ������㷨
 */
public class Solution13 {
	public void reOrderArray(int [] array) {
		for (int i = 1; i < array.length; i ++){
			if(array[i] % 2 == 1){
				int temp = array[i];
				int j = i - 1;
				while (j >= 0 && array[j] % 2 == 0){
					array[j + 1] = array[j];
					j --;
				}
				array[j + 1] = temp;
			}
		}
	}
}
