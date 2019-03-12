package algorithm.stack.ջ����;

import java.util.Stack;

/**
 * TestProject algorithm.stack.ջ����
 *
 * @author Lichaojie
 * @version 2018/8/10 15:33
 *
 * 1.��stack����ջ��������Ϊ��ǰԪ��cur
 * 2.���cur�Qhelpջ��Ԫ�أ���helpΪ�գ�����curѹ��help
 * 3.���򣬽�help�е�Ԫ����һ������ѹ��stack��ֱ������2
 * ��ֹ������stackջΪ��
 */
public class Main {
	public static void sortStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<>();

		while (!stack.empty()){
			int top = stack.pop();
			while (!help.empty() && top > help.peek()){
				stack.push(help.pop());
			}
			help.push(top);
		}

		while (!help.empty()){
			stack.push(help.pop());
		}
	}

	public static void main(String[] args){
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);

		stack.forEach(n -> System.out.print(n + " "));
		sortStack(stack);
		stack.forEach(n -> System.out.print(n + " "));
	}
}
