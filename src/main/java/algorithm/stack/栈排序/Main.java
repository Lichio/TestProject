package algorithm.stack.栈排序;

import java.util.Stack;

/**
 * TestProject algorithm.stack.栈排序
 *
 * @author Lichaojie
 * @version 2018/8/10 15:33
 *
 * 1.从stack做出栈操作，记为当前元素cur
 * 2.如果cur≦help栈顶元素（或help为空），将cur压入help
 * 3.否则，将help中的元素逐一弹出，压入stack，直到满足2
 * 终止条件：stack栈为空
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
