package oj.nk.包含min函数的栈;

import java.util.Iterator;
import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/6 19:21
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution20 {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> min = new Stack<>();//辅助栈，存储每一步的最小值
	public void push(int node) {
		stack.push(node);
		if (min.size() == 0 || node < min.peek()){
			min.push(node);
		}else {
			min.push(min.peek());
		}
	}

	public void pop() {
		stack.pop();
		min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return min.peek();
	}
}
