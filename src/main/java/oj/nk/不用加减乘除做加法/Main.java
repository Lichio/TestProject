package oj.nk.���üӼ��˳����ӷ�;

/**
 * TestProject oj.nk.���üӼ��˳����ӷ�
 *
 * @author Lichaojie
 * @version 2018/5/16 21:13
 *
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */
public class Main {
	public int Add(int num1,int num2) {
		int sum,carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}while (num2 != 0);
		return num1;
	}
}
