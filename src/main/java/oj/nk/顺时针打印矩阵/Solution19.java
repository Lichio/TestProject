package oj.nk.˳ʱ���ӡ����;


import java.util.ArrayList;
import java.util.List;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/6 18:38
 *
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬����������¾���
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 *
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19 {
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		return print(matrix,0,matrix.length - 1,0,matrix[0].length - 1);
	}

	//ÿ�λ�ȡ���������Ȧ
	public static ArrayList<Integer> print(int[][] matrix,int xl,int xr,int yl,int yr){
		ArrayList<Integer> list = new ArrayList<>();
		if(xl == xr){
			for (int i = yl; i <= yr; i ++){
				list.add(matrix[xl][i]);
			}
			return list;
		}
		if(yl == yr){
			for (int i = xl; i <= xr; i ++){
				list.add(matrix[i][yl]);
			}
			return list;
		}

		//��������Ͻ�������
		for (int i = yl; i <= yr; i ++){
			list.add(matrix[xl][i]);
		}
		//���������λ��������
		for (int i = xl + 1; i <= xr; i ++){
			list.add(matrix[i][yr]);
		}
		//Ȼ��������
		for (int i = yr - 1; i >= yl; i --){
			list.add(matrix[xr][i]);
		}
		//��������
		for (int i = xr - 1; i >= xl + 1; i --){
			list.add(matrix[i][yl]);
		}
		xl = xl + 1;
		xr = xr - 1;
		yl = yl + 1;
		yr = yr - 1;
		if(xl <= xr && yl <= yr){
			list.addAll(print(matrix,xl,xr,yl,yr));
		}
		return list;
	}

	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		List<Integer> list = printMatrix(matrix);
		for (int n : list){
			System.out.print(n + " ");
		}
	}
}
