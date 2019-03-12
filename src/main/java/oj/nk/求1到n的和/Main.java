package oj.nk.求1到n的和;

/**
 * TestProject oj.nk.求1到n的和
 *
 * @author Lichaojie
 * @version 2018/5/15 22:12
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * ① 使用递归
 * ②
 * ③
 */
public class Main {
	public int Sum_Solution(int n) {
		if(n == 1) return 1;
		return n + Sum_Solution(n - 1);
	}
}
