package oj.nk.��ת����˳����;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * TestProject oj.nk.��ת����˳����
 *
 * @author Lichaojie
 * @version 2018/5/16 20:21
 *
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
 * ��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class Main {
	public String ReverseSentence(String str) {
		if(str == null) return null;
		if(str.length() == 0 || str.length() == 1) return str;
		String[] strings = str.split(" ");
		if(strings.length == 0) return str;
		List<String> list = Arrays.asList(strings);
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for (String s : list){
			sb.append(s);
			sb.append(" ");
		}
		if(sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
