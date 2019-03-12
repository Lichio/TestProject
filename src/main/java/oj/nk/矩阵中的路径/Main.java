package oj.nk.�����е�·��;

import java.util.Stack;

/**
 * TestProject oj.nk.�����е�·��
 *
 * @author Lichaojie
 * @version 2018/6/12 20:10
 *
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
 * ����
 *        a b c e
 *        s f c s
 *        a d e e
 * �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
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

	// ���ﵱǰλ��ʱ�Ƿ�����ƥ������
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
				//���֮��Ĺ�������һ��·�����㣬����true
				if (go(matrix,rows,cols,str,start + 1,startX,startY + 1,flag,sx,sy,ss) ||
						go(matrix,rows,cols,str,start + 1,startX + 1,startY,flag,sx,sy,ss)||
						go(matrix,rows,cols,str,start + 1,startX,startY - 1,flag,sx,sy,ss)||
						go(matrix,rows,cols,str,start + 1,startX - 1,startY,flag,sx,sy,ss)){
					return true;
				}
				//ĳһ���ڵ����ڵ����нڵ㶼������ƥ������������
				else {
					flag[sx.peek() * cols + sy.peek()] = 0;
					sx.pop();
					sy.pop();
					ss.pop();
					return !sx.isEmpty() && go(matrix, rows, cols, str, ss.peek(), sx.peek(), sy.peek(), flag, sx, sy, ss);
				}

			}
		}
		//��ǰ�ڵ㲻����ƥ������
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