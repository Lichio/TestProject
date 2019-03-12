package oj.nk.字符流中第一个不重复的字符;


import java.util.LinkedHashMap;

/**
 * TestProject oj.nk.字符流中第一个不重复的字符
 *
 * @author Lichaojie
 * @version 2018/6/11 16:47
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Main {
	LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

	//Insert one char from stringstream
	public void Insert(char ch) {
		int num = 1;
		if(map.keySet().contains(ch)){
			num += map.get(ch);
		}
		map.put(ch,num);
	}

	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		for (char c : map.keySet()){
			if(map.get(c) == 1){
				return c;
			}
		}
		return '#';
	}
}
