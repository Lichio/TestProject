package algorithm.KMP;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

/**
 * algorithm.KMP
 * Created on 2017/12/7
 *
 * @author Lichaojie
 */
public class KMPTest {


	/**
	 *
	 * @param s 主串
	 * @param t 模式串
	 * @return
	 */
	public static int get_kmp(String s,String t){
		int[] next = get_next(t);

		int i = 0;
		int j = 0;

		while (i < s.length() && j < t.length()){
			if(s.charAt(i) == t.charAt(j)){
				++ i;
				++ j;
			}else {
				j = next[j + 1] - 1;
			}
		}

		if(j >= t.length()) return i - t.length();
		else return 0;
	}

	/**
	 * 当主串中的第i个字符与模式串中的第j个字符不匹配时，主串中的第i个字符应该与模式串中的第next[j]个字符进行比较
	 */
	public static int[] get_next(String t){
		int[] next = new int[t.length() + 1];
		next[1] = 0;
		int i = 1;
		int j = 0;

		while (i < t.length()){
			if(j == 0 || t.charAt(i - 1) == t.charAt(j - 1)){
				++ i;
				++ j;
				next[i] = j;
			}else {
				j = next[j];
			}
		}

		return next;
	}

	public static int[] get_nextval(String t){
		int[] nextval = new int[t.length() + 1];
		nextval[1] = 0;
		int i = 1;
		int j = 0;

		while (i < t.length()){
			if(j == 0 || t.charAt(i - 1) == t.charAt( j - 1)){
				++ i;
				++ j;
				if(t.charAt(i - 1) != t.charAt(j - 1)){
					nextval[i] = j;
				}else {
					nextval[i] = nextval[j];
				}
			}else {
				j = nextval[j];
			}
		}

		return nextval;
	}

	public static void main(String[] args){
		int[] next = get_next("abaabcac");
		for (int i = 1; i < next.length; i ++){
			System.out.print(next[i] + " ");
		}

		System.out.println();

		int[] nextval = get_nextval("aaaab");
		for (int i = 1; i < nextval.length; i ++){
			System.out.print(nextval[i] + " ");
		}
		String s = "aaabcac";
		String t = "abc";
		System.out.println("\n" + get_kmp(s,t));
	}

}
