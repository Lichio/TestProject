package oj.nk.�����г��ִ�������һ�������;

import java.util.HashMap;
import java.util.Map;

/**
 * TestProject oj.nk.�����г��ִ�������һ�������
 *
 * @author Lichaojie
 * @version 2018/5/9 22:05
 */
public class Main {
	public static int MoreThanHalfNum_Solution(int [] array){
		int num = array[0];
		int times = 1;
		for (int i = 1 ; i < array.length; i ++){
			if(times == 0){
				num = array[i];
				times = 1;
			} else if(array[i] == num){
				times ++;
			} else {
				times --;
			}
		}
		return checkMoreThanHelf(array,num) ? num : 0;
	}

	// �ж��ҵ������� �����Ƿ񳬹�����
	public static boolean checkMoreThanHelf(int[] array, int num){
		int times = 0;
		for (int n : array){
			if(n == num){
				times ++;
			}
		}
		return times > array.length >> 1;
	}

	public static void main(String[] args){
		int[] array = new int[]{1,2,2,2,2,2,3,4};
		System.out.println(MoreThanHalfNum_Solution(array));
	}
}
