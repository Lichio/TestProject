package oj.leetcode.max_points_on_a_line;

/**
 * TestProject oj.leetcode.maxPointsOnALline
 *
 * @author Lichaojie
 * @version 2018/6/13 15:59
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 注意多个点相同的情况
 */
public class Main {
	public int maxPoints(Point[] points) {
		if(points == null) return 0;
		if(points.length == 1) return 1;
		if(points.length == 2) return 2;
		int index = 0;
		while (index < points.length - 1 && points[index].x == points[index + 1].x && points[index].y == points[index + 1].y){
			index ++;
		}
		if(index == points.length - 1) return points.length;
		int max = 0;
		int count;
		for (int i = 0 ; i < points.length; i ++){
			for (int j = i + 1 ; j < points.length; j ++){
				Point point1 = points[i];
				Point point2 = points[j];
				if(point1.x == point2.x && point1.y == point2.y) continue;
				count = 0;
				for (Point point : points) {
					if ((point.x - point1.x) * (point.y - point2.y) == (point.x - point2.x) * (point.y - point1.y)) {
						count++;
					}
				}
				if(count > max) max = count;
			}
		}
		return max;
	}
}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
