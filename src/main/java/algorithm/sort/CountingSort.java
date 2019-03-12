package algorithm.sort;

/**
 * TestProject algorithm.sort
 *
 * @author Lichaojie
 * @version 2018/3/26 19:31
 *
 * �ҳ��������������������С��Ԫ��
 * ͳ��������ÿ��ֵΪi��Ԫ�س��ֵĴ�������������C �ĵ�i��
 * �����еļ����ۼӣ���C �еĵ�һ��Ԫ�ؿ�ʼ��ÿһ���ǰһ����ӣ�
 * �������Ŀ�����飺��ÿ��Ԫ��i����������ĵ�C[i]�ÿ��һ��Ԫ�ؾͽ�C[i]��ȥ1
 */
public class CountingSort {
	public int[] countingSort(int[] A, int n) {
		if(n == 0) return new int[0];

		int min;
		int max;

		min = max = A[0];
		for (int i = 1; i < n; i ++){
			if(min > A[i]) min = A[i];
			if(max < A[i]) max = A[i];
		}

		int[] c = new int[max - min + 1];

		for (int m : A){
			c[m - min] = c[m - min] + 1;
		}

		for (int i = 1;i < c.length; i ++){
			c[i] = c[i] + c[i - 1];
		}

		int[] result = new int[n];

		for (int m : A){
			result[c[m - min] - 1] = m;
			c[m - min] = c[m - min] - 1;
		}

		return result;
	}
}
