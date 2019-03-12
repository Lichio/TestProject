package oj.nk.矩阵中的路径;

import java.util.Stack;

/**
 * TestProject oj.nk.矩阵中的路径
 *
 * @author Lichaojie
 * @version 2018/6/12 20:10
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 *        a b c e
 *        s f c s
 *        a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Main {
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(str.length > rows * cols) return false;

		int[] flag = new int[matrix.length];
		for (int i = 0 ; i < flag.length; i ++){
			flag[i] = 0;
		}

		Stack<Integer> sx = new Stack<>();
		Stack<Integer> sy = new Stack<>();
		Stack<Integer> ss = new Stack<>();
		for (int i = 0; i < rows; i ++){
			for (int j = 0 ; j < cols ; j ++){
				if(matrix[i * cols + j] == str[0]){
					if(go(matrix,rows,cols,str,0,i,j,flag,sx,sy,ss)){
//						System.out.println(sx);
//						System.out.println(sy);
						return true;
					}
				}
			}
		}
		return false;
	}

	// 到达当前位置时是否满足匹配条件
	public static boolean go(char[] matrix, int rows, int cols, char[] str, int start, int startX, int startY, int[] flag, Stack<Integer> sx, Stack<Integer> sy,Stack<Integer> ss){
		if(startX >= 0 && startX < rows && startY >= 0 && startY < cols && matrix[startX * cols + startY] == str[start] && flag[startX * cols + startY] == 0){
			if(start == str.length - 1){
				System.out.println("case1 : {" + startX + "," + startY + "}");
				return true;
			}else {
				System.out.println("case2 : {" + startX + "," + startY + "}");
				sx.add(startX);
				sy.add(startY);
				ss.add(start);
				flag[startX * cols + startY] = 1;
				//如果之后的过程中有一条路径满足，返回true
				if (go(matrix,rows,cols,str,start + 1,startX,startY + 1,flag,sx,sy,ss) ||
						go(matrix,rows,cols,str,start + 1,startX + 1,startY,flag,sx,sy,ss)||
						go(matrix,rows,cols,str,start + 1,startX,startY - 1,flag,sx,sy,ss)||
						go(matrix,rows,cols,str,start + 1,startX - 1,startY,flag,sx,sy,ss)){
					return true;
				}
				//某一个节点相邻的所有节点都不满足匹配条件，回溯
				else {
					flag[sx.peek() * cols + sy.peek()] = 0;
					sx.pop();
					sy.pop();
					ss.pop();
					return !sx.isEmpty() && go(matrix, rows, cols, str, ss.peek(), sx.peek(), sy.peek(), flag, sx, sy, ss);
				}

			}
		}
		//当前节点不满足匹配条件
		else {
			return false;
		}
	}

	public static void main(String[] args){
		char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		int rows = 5;
		int cols = 8;
		for (int i = 0; i < rows ; i ++){
			for (int j = 0 ; j < cols; j ++){
				System.out.print(matrix[i * cols + j] + " ");
			}
			System.out.println();
		}
		char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();
		System.out.println(hasPath(matrix,rows,cols,str));
	}
}

//
//