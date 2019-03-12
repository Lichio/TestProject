package oj.nk.第一个只出现一次的字符;

import java.util.HashMap;

/**
 * TestProject oj.nk.第一个只出现一次的字符
 *
 * @author Lichaojie
 * @version 2018/4/12 21:39
 *
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Solution {
	public int FirstNotRepeatingChar(String str) {
		HashMap<Character,Integer> map = new HashMap<>();

		char[] chars = str.toCharArray();
		for (char s : chars){
			if(map.keySet().contains(s)){
				map.put(s,map.get(s) + 1);
			}else {
				map.put(s,1);
			}
		}

		for (int i = 0; i < chars.length; i ++){
			if(map.get(chars[i]) == 1) return i;
		}
		return -1;
	}
}
