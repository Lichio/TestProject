package oj.nk.�����˻�����;

/**
 * TestProject oj.nk.�����˻�����
 *
 * @author Lichaojie
 * @version 2018/5/16 22:01
 *
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */
public class Main {
	public int[] multiply(int[] A) {
		int[] B = new int[A.length]; //���
		int[] C = new int[A.length];
		int[] D = new int[A.length];

		C[0] = 1;
		for (int i = 1; i < C.length; i ++){
			C[i] = C[i - 1] * A[i - 1];
		}

		D[D.length - 1] = 1;
		for (int i = D.length - 2; i >= 0; i --){
			D[i] = D[i + 1] * A[i + 1];
		}

		for (int i = 0; i < B.length; i ++){
			B[i] = C[i] * D[i];
		}

		return B;
	}
}
