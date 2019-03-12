package algorithm.stack.ջ������;

import java.util.Stack;

/**
 * TestProject algorithm.stack.ջ������
 * ֻʹ�õݹ��ջ����Ĳ���
 *
 * @author Lichaojie
 * @version 2018/8/7 16:55
 */
public class Main {

	/**
	 * �Ƴ�ջ��Ԫ�ز�����
	 * @param stack
	 * @return
	 */
	public static int get(Stack<Integer> stack){
		int result = stack.pop();

		if(stack.isEmpty()){
			return result;
		}else {
			int last = get(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int i = get(stack);
		reverse(stack);
		stack.push(i);
	}

	public static void main(String[] args){
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 10; i ++){
			stack.push(i);
		}
		stack.forEach(n -> System.out.print(n + " "));
		System.out.println();

		reverse(stack);

		stack.forEach(n -> System.out.print(n + " "));
	}
}
