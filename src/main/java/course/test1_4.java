package course;

/**
 * TestProject course
 *
 * @author Lichaojie
 * @version 2018/3/15 21:53
 *
 * �������һ���ַ���A����A��ǰ������һ����Ų�����ȥ�γɵ��ַ�����ΪA����ת�ʡ�
 * ����A="12345",A����ת����"12345","23451","34512","45123"��"51234"�����������ַ���A��B�����ж�A��B�Ƿ�Ϊ��ת�ʡ�
 * ���������ַ���A��B�����ǵĳ���lena��lenb���뷵��һ��boolֵ�����������Ƿ�Ϊ��ת�ʡ�
 * ����������
 * "cdab",4,"abcd",4
 * ���أ�true
 */
public class test1_4 {
	public boolean chkRotation(String A, int lena, String B, int lenb) {
		if(lena != lenb) return false;

		StringBuffer str1 = new StringBuffer(A);
		StringBuffer str2 = new StringBuffer(B);
		str1.append(str1);
		return str1.toString().contains(str2);
	}
}
