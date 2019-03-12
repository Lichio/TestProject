package oj.nk.��һ��ֻ����һ�ε��ַ�;

import java.util.HashMap;

/**
 * TestProject oj.nk.��һ��ֻ����һ�ε��ַ�
 *
 * @author Lichaojie
 * @version 2018/4/12 21:39
 *
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
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
