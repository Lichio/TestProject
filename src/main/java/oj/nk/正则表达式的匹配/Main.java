package oj.nk.正则表达式的匹配;

/**
 * TestProject oj.nk.正则表达式的匹配
 *
 * @author Lichaojie
 * @version 2018/5/21 20:19
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Main {
	public boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null){
			return false;
		}

		int i;
		char[] str1 = new char[str.length + 1];
		for (i = 0 ; i < str.length; i ++){
			str1[i] = str[i];
		}
		str1[i] = '\0';

		char[] pattern1 = new char[pattern.length + 1];
		for (i = 0; i < pattern.length; i ++){
			pattern1[i] = pattern[i];
		}
		pattern1[i] = '\0';
		return matchCore(str1,pattern1,0,0);
	}

	boolean matchCore(char[] str,char[] pattern,int index1,int index2){
		if(str[index1] == '\0' && pattern[index2] == '\0'){
			return true;
		}

		if(str[index1] != '\0' && pattern[index2] == '\0'){
			return false;
		}

		if(pattern[index2 + 1] == '*'){
			if(str[index1] == pattern[index2] || (pattern[index2] == '.' && str[index1] != '\0')){
				return matchCore(str,pattern,index1 + 1,index2 + 2) ||
						matchCore(str,pattern,index1 + 1, index2) ||
						matchCore(str,pattern,index1,index2 + 2);
			}else {
				return matchCore(str,pattern,index1,index2 + 2);
			}
		}

		if(str[index1] == pattern[index2] || (pattern[index2] == '.' && str[index1] != '\0')){
			return matchCore(str,pattern,index1 + 1,index2 + 1);
		}
		return false;
	}
}
