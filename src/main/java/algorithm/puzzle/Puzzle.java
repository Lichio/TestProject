package algorithm.puzzle;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * TestProject algorithm
 *
 * @author Lichaojie
 * @version 2018/4/10 15:23
 */
public class Puzzle {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()){
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] puzzle = new int[N][M];

			for (int i = 0 ; i < N; i ++){
				for (int j = 0 ; j < M; j ++){
					puzzle[i][j] = sc.nextInt();
				}
			}

			Stack<Integer> sx = new Stack<>();
			Stack<Integer> sy = new Stack<>();
			sx.push(0);
			sy.push(0);
			go(0,0,puzzle,sx,sy);

			Collections.reverse(sx);
			Collections.reverse(sy);
			while (!sx.isEmpty()){
				System.out.println("(" + sx.pop() + "," + sy.pop() + ")");
			}
		}

	}

	public static void go(int x,int y,int[][] puzzle,Stack<Integer> sx,Stack<Integer> sy){
		if(x == puzzle.length - 1 && y == puzzle[0].length - 1) {
			puzzle[x][y] = 1;
			if(x != sx.peek() || y != sy.peek()){
				sx.push(x);
				sy.push(y);
			}
			return;
		}

		if(x >= 0 && x < puzzle.length && y >= 0 && y < puzzle[0].length && puzzle[x][y] == 0){
			puzzle[x][y] = 1;
			if(x != sx.peek() || y != sy.peek()){
				sx.push(x);
				sy.push(y);
			}
		}else {
			return;
		}

		go(x,y + 1,puzzle,sx,sy);//right
		go(x + 1,y,puzzle,sx,sy);//down
		go(x,y - 1,puzzle,sx,sy);//left
		go(x - 1,y,puzzle,sx,sy);//up

		if(x == sx.peek() && y == sy.peek()){
			sx.pop();
			sy.pop();
		}
	}
}

//
//5 5
//		0 1 0 0 0
//		0 1 0 1 0
//		0 0 0 0 0
//		0 1 1 1 0
//		0 0 0 1 0