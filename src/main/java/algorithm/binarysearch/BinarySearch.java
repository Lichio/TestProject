package algorithm.binarysearch;


/**
 * TestProject algorithm.binarysearch
 *
 * @author Lichaojie
 * @version 2018/3/23 19:02
 */
public class BinarySearch {

	/**
	 * 非递归实现
	 * @param array
	 * @param n
	 * @return
	 */
	public static int search1(int[] array,int n){
		int l = 0;
		int r = array.length - 1;
		if(n < array[l] || n > array[r]) return -1;
		while (l <= r){
			int m = l + (r - l) / 2;
			if(n > array[m]){
				l = m + 1;
			}else if(n < array[m]){
				r = m - 1;
			}else {
				return m;
			}
		}
		return -1;
	}

	/**
	 * 递归实现
	 * @param array
	 * @param start
	 * @param end
	 * @param n
	 * @return
	 */
	public static int search2(int[] array,int start,int end,int n){
		if(n < array[start] || n > array[end]) return -1;
		int mid = start + (end - start) / 2;
		if(n > array[mid]){
			return search2(array,mid + 1,end,n);
		}else if(n < array[mid]){
			return search2(array,start,mid - 1,n);
		}else {
			return mid;
		}
	}

	public static void main(String[] args){
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(search1(array,0));
		System.out.println(search2(array,0,array.length,0));

	}
}
