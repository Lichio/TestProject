package oj.nk.�滻�ո�;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 17:07
 *
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 *
 * ʱ�����ƣ�1�� �ռ����ƣ�32768K �ȶ�ָ����471895
 * ����֪ʶ�㣺 �ַ���
 */
public class Solution2 {
	public static String replaceSpace(StringBuffer str) {
		String s = str.toString();
		String result = s.replace(" ","%20");
		return result;
	}

	public static void main(String[] args){
		String s = replaceSpace(new StringBuffer("We Are Happy"));
		System.out.println(s);
	}
}
