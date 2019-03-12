package oj.nk.把字符串转换成整数;

/**
 * TestProject oj.nk.把字符串转换成整数
 *
 * @author Lichaojie
 * @version 2018/5/16 21:32
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
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
