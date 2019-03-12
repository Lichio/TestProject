package oj.nk.旋转数组的最小数字;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/3/1 15:11
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution6 {
	public int minNumberInRotateArray(int [] array) {
		if(array.length == 0) return 0;

		//从后往前，两两比较，直到遇到相邻两个数 左数>右数，此时右数为最小数
		for (int i = array.length - 1; i > 0; i --){
			if(array[i - 1] > array[i]){
				return array[i];
			}
		}

		//如果没有左数>右数的情况，则整个数组所有元素相同，随意返回一个
		return array[0];
	}
}
