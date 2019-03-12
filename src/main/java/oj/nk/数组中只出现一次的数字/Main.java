package oj.nk.数组中只出现一次的数字;

/**
 * TestProject oj.nk.数组中只出现一次的数字
 *
 * @author Lichaojie
 * @version 2018/5/15 20:39
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
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
