package oj.nk.ջ��ѹ��$��������;

import java.util.Stack;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/8 20:29
 *
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 *
 * ˼·������ջ���У��˴�ΪpushA���е���������ջ��ÿ����ջ���顾��ǰջ��Ԫ���Ƿ���ڳ�ջ���У��˴�ΪpopA���ĵ�һ��δ����Ԫ�ء�
 * �����ȣ���ջ��Ԫ�ص���
 * �������ȣ�������pushA�е���������ջ����
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
