package oj.nk.������ֻ����һ�ε�����;

/**
 * TestProject oj.nk.������ֻ����һ�ε�����
 *
 * @author Lichaojie
 * @version 2018/5/15 20:39
 *
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 *
 * num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
 * ��num1[0],num2[0]����Ϊ���ؽ��
 */
public class Main {
	public static void main(String[] args){
		int[] array = new int[]{2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(array,num1,num2);

	}

	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		int c = 0;
		for (int i = 0; i < array.length; i ++){
			c ^= array[i];
		}

		int n = 1;
		while (true){
			if((n & c) == n){
				break;
			}else {
				n = n << 1;
			}
		}

		int a = 0;
		for (int i = 0; i < array.length; i ++){
			if((n & array[i]) == n){
				a ^= array[i];
			}
		}

		int b = c ^ a;
		num1[0] = a;
		num2[0] = b;
	}
}
