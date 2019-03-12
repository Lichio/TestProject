package oj.nk.�����������ĺ����������;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/4/10 15:47
 *
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class Solution23 {
	public static boolean VerifySquenceOfBST(int [] sequence) {
		return sequence.length != 0 && verify(0, sequence.length - 1, sequence);
	}

	public static boolean verify(int start,int end,int[] sequence) {
		if(end <= start) return true;
		int mid;
		int i = start;
		while (sequence[i] < sequence[end] && i < end) {
			i++;
		}
		mid = i;
		for (int j = mid; j < end; j++) {
			if (sequence[j] < sequence[end]) return false;
		}

		return verify(start, mid - 1, sequence) && verify(mid, end - 1, sequence);

	}

	public static void main(String[] args){
		if(false || print() && print()){
			System.out.println("main");
		}

		int[] sequence = {6,12,9,11,10,8};
		System.out.println(VerifySquenceOfBST(sequence));
	}

	public static boolean print(){
		System.out.println("print");
		return true;
	}
}
