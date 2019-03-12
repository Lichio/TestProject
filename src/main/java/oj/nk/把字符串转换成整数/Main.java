package oj.nk.���ַ���ת��������;

/**
 * TestProject oj.nk.���ַ���ת��������
 *
 * @author Lichaojie
 * @version 2018/5/16 21:32
 *
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */
public class Main {
	public int StrToInt(String str) {
		if(str == null || str.length() == 0) return 0;
		char[] chars = str.toCharArray();
		int n = 0;
		int i = chars[0] == '+' || chars[0] == '-' ? 1 : 0;
		for (; i < chars.length; i ++){
			if(!Character.isDigit(chars[i])){
				return 0;
			}else {
				n = n * 10 + (chars[i] - '0');
			}
		}
		if(chars[0] == '-') return n * -1;
		return n;
	}
}
