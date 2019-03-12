package oj.nk.数值的整数次方;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 16:59
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution12 {
	public double Power(double base, int exponent) {
		return Math.pow(base,exponent);
	}

	public double Power1(double base, int exponent) {
		if(exponent == 0) return 1;
		if(exponent == 1) return base;

		double result = Power1(base,exponent >> 1);
		result *= result;
		if((exponent & 1) == 1) result *= base;
		return result;
	}
}
