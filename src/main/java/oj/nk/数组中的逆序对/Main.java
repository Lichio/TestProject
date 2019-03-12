package oj.nk.数组中的逆序对;

/**
 * TestProject oj.nk.数组中的逆序对
 *
 * @author Lichaojie
 * @version 2018/5/14 20:22
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Main {
	public static void main(String[] args){
		int[] array = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
		System.out.println(InversePairs(array));
	}

	public static int InversePairs(int [] array) {
		if(array == null || array.length < 0) return 0;
		int[] copy = new int[array.length];

		for (int i = 0 ; i < array.length; i ++){
			copy[i] = array[i];
		}
		long count = pairs(array,copy,0,array.length - 1);
		return (int)(count % 1000000007);
	}

	public static long pairs(int[] array,int[] copy,int start,int end){
		if(start == end){
			copy[start] = array[start];
			return 0;
		}

		int length = (end - start) / 2;
		long left = pairs(copy,array,start,start + length);
		long right = pairs(copy,array,start + length + 1,end);

		int i = start + length;
		int j = end;

		int index = end;
		long count = 0;

		while (i >= start && j >= start + length + 1){
			if (array[i] > array[j]){
				copy[index --] = array[i --];
				count += j - start - length;
			}else {
				copy[index --] = array[j --];
			}
		}

		while (i >= start){
			copy[index --] = array[i --];
		}
		while (j >= start + length + 1){
			copy[index --] = array[j --];
		}

		return (left + right + count);
	}
}
