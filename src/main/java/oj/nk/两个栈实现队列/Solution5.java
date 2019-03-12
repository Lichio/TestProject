package oj.nk.����ջʵ�ֶ���;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:00
 *
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class Solution5 {
	Stack<Integer> stack1 = new Stack<Integer>();//������ת����
	Stack<Integer> stack2 = new Stack<Integer>();//����ʵ�ʴ洢����

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
