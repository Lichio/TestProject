package oj.nk.字符串的排列;

import java.lang.reflect.Array;
import java.util.*;

/**
 * TestProject oj.nk.字符串的排列
 * 字符串的全排列
 * @author Lichaojie
 * @version 2018/5/9 21:27
 */
public class Main {


	public static ArrayList<String> Permutation(String str) {
		if(str == null) return null;
		if(str.length() == 0) return new ArrayList<>();

		if(str.length() == 1){
			ArrayList<String> list = new ArrayList<>(1);
			list.add(str);
			return list;
		}

		char c = str.charAt(0);
		ArrayList<String> list = Permutation(str.substring(1,str.length()));

		HashSet<String> strSet = new HashSet<>();
		for (String s : list){
			strSet.add(c + s);
			char[] chars = s.toCharArray();
			for (int i = 0 ; i < chars.length ; i ++){
				char ct = chars[i];
				chars[i] = c;
				strSet.add(ct + new String(chars));
				chars[i] = ct;
			}
		}

		ArrayList<String> strList = new ArrayList<>(strSet.size());
		strList.addAll(strSet);
		Collections.sort(strList);
		return (strList);
	}

	public static void main(String[] args){
		ArrayList<String> list = Permutation("aazz");
		list.forEach(System.out::println);
	}
}
