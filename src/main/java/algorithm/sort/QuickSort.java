package algorithm.sort;

import java.util.Stack;

/**
 * algorithm.sort
 * Created on 2017/11/8
 *
 * @author Lichaojie
 */
public class QuickSort {


	/**
	 * * * * �������� * * * *
	 * ����������õ�˼���Ƿ���˼�롣
	 * �����������ҳ�һ��Ԫ�أ������Ͽ��������һ������Ϊ��׼(pivot),Ȼ���������з�������,ʹ��׼���Ԫ�ص�ֵ�������ڻ�׼ֵ,
	 * ��׼�ұߵ�Ԫ��ֵ ����С�ڻ�׼ֵ�������Ϊ��׼��Ԫ�ص�������������ȷλ�á�
	 * �ݹ�������򣬽�����n-1��Ԫ��Ҳ��������������ȷλ�á����ÿ��Ԫ�ض�������������ȷλ�ã�������ɡ�
	 *
	 * * * * �Ż���ʽ * * * *
	 * �� ������������ʱ����Q47��ʹ�ò�������
	 * �� ѡȡpivot�ķ�ʽ����ѡȡ���������λ���������������
	 * �� ��pivot��ȵ�Ԫ�ز��ٽ�����һ�λ���
	 * ��
	 * * * * * * * * * * * *
	 */

	/**
	 * partition��������������Ԫ�طֳ����飬����һ����ÿһԪ�ص�ֵ������һ����ÿһ��Ԫ�ص�ֵС
	 * @param source
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(Integer[] source,int low,int high){
		int key = source[low];//ѡȡ��һ��Ԫ��Ϊ��Ԫ
		while(low < high){
			while(low < high && source[high] >= key){ //�Ӻ���ǰ������Ѱ�ұ���ԪС��Ԫ��
				high--;
			}
			source[low] = source[high];
			while(low < high && source[low] <= key){ //��ǰ���������Ѱ�ұ���Ԫ���Ԫ��
				low++;
			}
			source[high] = source[low];
		}
		source[low] = key;
		return low;
	}

	/**
	 * �ݹ����
	 * @param source
	 * @param low
	 * @param high
	 */
	public static void quickSort1(Integer[] source,int low,int high){
		if(low < high){
			int mid = partition(source,low,high);
			quickSort1(source,low,mid - 1);
			quickSort1(source,mid + 1,high);
		}
	}

	/**
	 * �ǵݹ����
	 * ��ʵ������ջ����ÿһ���������Ӵ�����βԪ���±꣬��һ��whileѭ��ʱȡ�������Χ������������н���partition����
	 * @param source
	 * @param low
	 * @param high
	 */
	public static void quickSort2(Integer[] source,int low,int high){
		Stack<Integer> stack = new Stack<>();
		if(low < high){
			int mid;
			stack.push(low);
			stack.push(high);
			while (!stack.isEmpty()){
				high = stack.pop();
				low = stack.pop();
				mid = partition(source,low,high);
				if(low < mid - 1){
					stack.push(low);
					stack.push(mid - 1);
				}
				if(high > mid + 1){
					stack.push(mid + 1);
					stack.push(high);
				}
			}
		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);
		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println();

		long time1 = System.nanoTime();
		quickSort2(integers,0,integers.length - 1);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n����ʱ��" + time);
	}
}
