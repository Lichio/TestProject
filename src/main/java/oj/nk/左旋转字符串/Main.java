package oj.nk.����ת�ַ���;

/**
 * TestProject oj.nk.����ת�ַ���
 *
 * @author Lichaojie
 * @version 2018/5/16 20:16
 *
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
 * Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class Main {
	public String LeftRotateString(String str,int n) {
		if(str == null) return null;
		if(str.length() < n) return str;
		return str.substring(n,str.length()) + str.substring(0,n);
	}
}
