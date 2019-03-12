package oj.nk.翻转单词顺序列;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * TestProject oj.nk.翻转单词顺序列
 *
 * @author Lichaojie
 * @version 2018/5/16 20:21
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
