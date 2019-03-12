package oj.nk.二进制中1的个数;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 16:47
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {
	public static int NumberOf1(int n) {
		//可直接获取整数的二进制表示（补码表示）
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
