package oj.nk.�˿���˳��;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TestProject oj.nk.�˿���˳��
 *
 * @author Lichaojie
 * @version 2018/5/16 20:34
 *
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
 * ����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 * LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�
 * Ϊ�˷������,�������Ϊ��С����0��
 */
public class Main {
	public boolean isContinuous(int [] numbers) {
		if(numbers.length == 0) return false;
		Arrays.sort(numbers);
		int n1 = 0;//��¼0�ĸ���
		int n2 = 0;//��¼��������������

		for (int i = 0; i < numbers.length - 1; i ++){
			if(numbers[i] == 0){
				n1 ++;
			}else {
				if(numbers[i + 1] - numbers[i] == 0){
					return false;
				}
				if(numbers[i + 1] - numbers[i] > 1){
					n2 += (numbers[i + 1] - numbers[i] - 1);
				}
			}
		}
		if(numbers[numbers.length - 1] == 0) n1 ++;

		if(n1 >= n2){
			return true;
		}else {
			return false;
		}
	}
}
