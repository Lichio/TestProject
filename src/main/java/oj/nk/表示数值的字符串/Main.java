package oj.nk.表示数值的字符串;

/**
 * TestProject oj.nk.表示数值的字符串
 *
 * @author Lichaojie
 * @version 2018/5/21 21:48
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Main {
	public static boolean isNumeric(char[] str) {
		if(str == null){
			return false;
		}

		StringBuilder base = new StringBuilder();
		StringBuilder exponent = new StringBuilder();

		int flag = str.length;
		for (int i = 0 ; i < str.length; i ++){
			if(str[i] == 'e' || str[i] == 'E'){
				flag = i;
				break;
			}
		}

		for (int i = 0; i < flag; i ++){
			if(Character.isLetter(str[i])){
				return false;
			}else {
				base.append(str[i]);
			}
		}

		for (int i = flag + 1; i < str.length; i ++){
			if(Character.isLetter(str[i])){
				return false;
			}else {
				exponent.append(str[i]);
			}
		}

		if(flag != str.length){
			return (isInteger(base.toString()) || isFloat(base.toString())) && isInteger(exponent.toString());
		}else {
			return (isInteger(base.toString()) || isFloat(base.toString()));
		}
	}

	static boolean isInteger(String str){
		try {
			Integer.parseInt(str);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}

	static boolean isFloat(String str){
		try {
			Float.parseFloat(str);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}

	public static void main(String[] args){
		char[] chars = "100".toCharArray();
		System.out.println(isNumeric(chars));
	}
}
