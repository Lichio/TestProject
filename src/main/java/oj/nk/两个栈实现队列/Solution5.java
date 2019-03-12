package oj.nk.两个栈实现队列;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:00
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution5 {
	Stack<Integer> stack1 = new Stack<Integer>();//用来中转数据
	Stack<Integer> stack2 = new Stack<Integer>();//用来实际存储数据

	public void push(int node) {
		stack2.push(node);
	}

	public int pop() {
		if(stack1.empty()){
			while (!stack2.empty()){
				stack1.push(stack2.pop());
			}
		}
		return stack1.pop();
	}

}
