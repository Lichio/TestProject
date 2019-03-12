package oj.nk.������ʽ��ƥ��;

/**
 * TestProject oj.nk.������ʽ��ƥ��
 *
 * @author Lichaojie
 * @version 2018/5/21 20:19
 *
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
 * ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
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
