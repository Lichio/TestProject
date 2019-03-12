package oj.nk.��ά�����еĲ���;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 9:05
 *
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 *
 * ʱ�����ƣ�1�� �ռ����ƣ�32768K �ȶ�ָ����543632
 * ����֪ʶ�㣺 ����
 */
public class Solution1 {
	public boolean Find(int target, int [][] array) {
		int row = array.length;
		if(row == 0){
			return false;
		}
		//System.out.println("row : " + row);
		int column = array[0].length;
		//System.out.println("column :" + column);
		if(column == 0){
			return false;
		}

		for (int i = 0; i < row; i ++){
			int l = 0;
			int h = column - 1;
			while (l < h){
				int t = (l + h)/2;
				if(target < array[i][t]){
					h = t - 1;
				}else if(target > array[i][t]){
					l = t + 1;
				}else {
					return true;
				}
			}

			if(target == array[i][l]){
				return true;
			}
		}
		return false;
	}
}
