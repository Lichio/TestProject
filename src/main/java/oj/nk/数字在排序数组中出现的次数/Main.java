package oj.nk.数字在排序数组中出现的次数;

/**
 * TestProject oj.nk.数字在排序数组中出现的次数
 *
 * @author Lichaojie
 * @version 2018/5/7 20:30
 */
public class Main {

	public static void main(String[] args){
		int[] array = new int[]{5,5,5,6,6,7};
		System.out.println(GetNumberOfK(array,5));
	}

	public static int GetNumberOfK(int [] array , int k) {
		int first = getFirstK(array,k,0,array.length - 1);
		int last = getLastK(array,k,0,array.length - 1);
		if(first != -1 && last != -1){
			return last - first + 1;
		}else {
			return 0;
		}
	}

	public static int getFirstK(int[] array,int k,int left,int right){
		int low = left;
		int high = right;
		if (low <= high){
			int mid = low + (high - low) / 2;
			if(k < array[mid]){
				high = mid - 1;
			}else if(k > array[mid]){
				low = mid + 1;
			}else {
				if(mid == 0 || array[mid - 1] != k){
					return mid;
				}else {
					high = mid - 1;
				}
			}
		}else {
			return -1;
		}
		return getFirstK(array,k,low,high);
	}

	public static int getLastK(int[] array,int k,int left,int right){
		int low = left;
		int high = right;
		if (low <= high){
			int mid = low + (high - low) / 2;
			if(k < array[mid]){
				high = mid - 1;
			}else if(k > array[mid]){
				low = mid + 1;
			}else {
				if(mid == array.length - 1 || array[mid + 1] != k){
					return mid;
				}else {
					low = mid + 1;
				}
			}
		}else {
			return -1;
		}
		return getLastK(array,k,low,high);
	}
}
