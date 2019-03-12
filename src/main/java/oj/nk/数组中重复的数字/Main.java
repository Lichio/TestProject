package oj.nk.�������ظ�������;

/**
 * TestProject oj.nk.�������ظ�������
 *
 * @author Lichaojie
 * @version 2018/5/16 21:42
 *
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */
public class Main {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers == null || numbers.length == 0 || numbers.length == 1) return false;

		int[] ints = new int[numbers.length];
		for (int i = 0 ; i< ints.length ; i ++){
			ints[i] = 0;
		}
		for (int i = 0 ; i < numbers.length; i ++){
			ints[numbers[i]] ++;
		}
		for (int i = 0 ; i < ints.length; i ++){
			if(ints[i] > 1){
				duplication[0] = i;
				return true;
			}
		}
		return false;
	}
}
