package oj.nk.栈的压入$弹出序列;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/8 20:29
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：将入栈序列（此处为pushA）中的数依次入栈，每次入栈后检查【当前栈顶元素是否等于出栈序列（此处为popA）的第一个未遍历元素】
 * 如果相等，将栈顶元素弹出
 * 如果不相等，继续将pushA中的数进行入栈操作
 */
public class Solution21 {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA.length == 0) return true;

		Stack<Integer> stack = new Stack<>();
		stack.push(pushA[0]);

		int push = 1;
		int pop = 0;
		while (pop < popA.length){
			if(popA[pop] == stack.peek()){
				stack.pop();
				pop ++;
			}else {
				if(push >= pushA.length){
					return false;
				}
				stack.push(pushA[push]);
				push ++;
			}
		}
		return stack.empty();
	}
}
