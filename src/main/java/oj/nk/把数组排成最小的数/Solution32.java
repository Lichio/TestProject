package oj.nk.�������ų���С����;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/24 21:40
 *
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
public class Solution32 {
	public static String PrintMinNumber(int [] numbers) {
		String[] strings = new String[numbers.length];
		for (int i = 0 ; i < numbers.length; i ++){
			strings[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(strings,(o1, o2) -> {
			String s1 = o1 + o2;
			String s2 = o2 + o1;
			if (s1.compareTo(s2) > 0) {
				return 1;
			} else if (s1.compareTo(s2) < 0) {
				return -1;
			} else {
				return 0;
			}
		});

		StringBuilder stringBuilder = new StringBuilder();
		Arrays.asList(strings).forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

	public static void main(String[] args){
		PrintMinNumber(new int[3]);
	}
}
