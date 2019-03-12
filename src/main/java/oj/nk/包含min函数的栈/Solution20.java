package oj.nk.����min������ջ;

import java.util.Iterator;
import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/6 19:21
 *
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 */
public class Solution20 {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> min = new Stack<>();//����ջ���洢ÿһ������Сֵ
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
