package oj.nk.����;

/**
 * TestProject oj.nk.����
 *
 * @author Lichaojie
 * @version 2018/4/12 21:10
 *
 * ��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7��
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */
public class Solution {
	public int GetUglyNumber_Solution(int index) {
		if(index == 0) return 0;

		// �洢���ҵ��ĳ���������
		int[] array = new int[index];

		array[0] = 1;

		int cur = 1,t2 = 0,t3 = 0,t5 = 0;

		while (cur < index){
			// ���㣺������֪�ĳ������γ�2������е�һ���ȵ�ǰ��������ĳ���
			while (t2 < cur - 1 && 2 * array[t2] <= array[cur - 1]){
				t2 ++;
			}
			while (t3 < cur - 1 && 3 * array[t3] <= array[cur - 1]){
				t3 ++;
			}
			while (t5 < cur - 1 && 5 * array[t5] <= array[cur - 1]){
				t5 ++;
			}

			// �µĳ�����������֪������2��3��5�Ľ������С����
			array[cur ++] = Math.min(2 * array[t2],Math.min(3 * array[t3],5 * array[t5]));
		}

		return array[index - 1];

	}
}
