package oj.nk.二维数组中的查找;

/**
 * TestProject oj.nk
 *
 * @author Lichaojie
 * @version 2018/2/28 9:05
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：543632
 * 本题知识点： 查找
 */
public class Solution1 {
	public boolean Find(int target, int [][] array) {
		int row = array.length;
		if(row == 0){
			return false;
		}
		//System.out.println("row : " + row);
		int column = array[0].length;
		//System.out.println("column :" + column);
		if(column == 0){
			return false;
		}

		for (int i = 0; i < row; i ++){
			int l = 0;
			int h = column - 1;
			while (l < h){
				int t = (l + h)/2;
				if(target < array[i][t]){
					h = t - 1;
				}else if(target > array[i][t]){
					l = t + 1;
				}else {
					return true;
				}
			}

			if(target == array[i][l]){
				return true;
			}
		}
		return false;
	}
}
