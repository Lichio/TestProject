package oj.nk.��ת�������С����;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:11
 *
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class Solution6 {
	public int minNumberInRotateArray(int [] array) {
		if(array.length == 0) return 0;

		//�Ӻ���ǰ�������Ƚϣ�ֱ���������������� ����>��������ʱ����Ϊ��С��
		for (int i = array.length - 1; i > 0; i --){
			if(array[i - 1] > array[i]){
				return array[i];
			}
		}

		//���û������>�������������������������Ԫ����ͬ�����ⷵ��һ��
		return array[0];
	}
}
