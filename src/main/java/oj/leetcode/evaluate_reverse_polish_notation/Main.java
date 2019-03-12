package oj.leetcode.evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * TestProject oj.leetcode.evaluateReversePolishNotation
 *
 * @author Lichaojie
 * @version 2018/6/13 15:39
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Main {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens){
			if (!isOperator(token)){
				stack.push(Integer.parseInt(token));
			}else {
				int rNum = stack.pop();
				int lNum = stack.pop();
				stack.push(doCompute(lNum,rNum,token));
			}
		}
		return stack.get(0);
	}

	boolean isOperator(String token){
		return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
	}

	int doCompute(int lNum,int rNum,String token){
		switch (token){
			case "+" :
				return lNum + rNum;
			case "-" :
				return lNum - rNum;
			case "*" :
				return lNum * rNum;
			case "/" :
				return lNum / rNum;
			default:
				return 0;
		}
	}
}
