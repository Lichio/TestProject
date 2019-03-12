package oj.nk.替换空格;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 17:07
 *
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：471895
 * 本题知识点： 字符串
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
