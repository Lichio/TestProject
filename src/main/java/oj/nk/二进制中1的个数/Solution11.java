package oj.nk.��������1�ĸ���;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 16:47
 *
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class Solution11 {
	public static int NumberOf1(int n) {
		//��ֱ�ӻ�ȡ�����Ķ����Ʊ�ʾ�������ʾ��
		String str = Integer.toBinaryString(n);
		System.out.println(str);

		int sum = 0;
		for (int i = 0; i < str.length(); i ++){
			if(str.charAt(i) == '1'){
				sum ++;
			}
		}

		return sum;
	}

	public static void main(String[] args){
		NumberOf1(2);
		NumberOf1(-1);

	}
}
