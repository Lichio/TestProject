package oj.nk.��ֵ�������η�;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 16:59
 *
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
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
