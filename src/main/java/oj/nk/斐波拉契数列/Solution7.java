package oj.nk.쳲���������;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:29
 *
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 * n<=39
 */
public class Solution7 {
	public int Fibonacci(int n) {
		if(n == 1 || n == 2) return 1;

		//�ݹ�
		//return Fibonacci(n - 1) + Fibonacci(n - 2);

		//�ǵݹ�
		int left = 1;
		int right = 1;
		int sum = 0;
		for (int i = 1; i < n - 1; i ++){
			sum = left + right;
			left = right;
			right = sum;
		}
		return sum;
	}
}
