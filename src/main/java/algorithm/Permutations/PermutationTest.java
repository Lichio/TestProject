package algorithm.Permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * algorithm.Permutations
 * Created on 2017/12/7
 * @author Lichaojie
 * @see oj.nk.字符串的排列.Main
 *
 * 打印从1到最大的n位数
 */
public class PermutationTest {
	public static List printNumber(int n){
		if (n < 0) return new ArrayList();

		List<String> result = new ArrayList<>();
		char[] number = new char[n];
		for (int i = 0 ; i < 10; i ++){
			number[0] = (char)(i + '0');
			printRecursive(result,number,n,0);
		}

		return result;
	}

	public static void printRecursive(List<String> list,char[] number,int length,int index){
		if (index == length - 1){
			list.add(String.valueOf(number));
			return;
		}
		for (int i = 0 ; i < 10;i ++){
			number[index + 1] = (char)(i + '0');
			printRecursive(list,number,length,index + 1);
		}
	}

	public static void main(String[] args){
		List list = printNumber(2);
		list.forEach(System.out::println);
	}
}

