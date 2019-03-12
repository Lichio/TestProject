package oj.nk.�ַ����е�һ�����ظ����ַ�;


import java.util.LinkedHashMap;

/**
 * TestProject oj.nk.�ַ����е�һ�����ظ����ַ�
 *
 * @author Lichaojie
 * @version 2018/6/11 16:47
 *
 * ��Ŀ����
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * �������:�����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
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
