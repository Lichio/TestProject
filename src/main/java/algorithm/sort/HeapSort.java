package algorithm.sort;

/**
 * algorithm.sort
 * Created on 2017/11/9
 *
 * @author Lichaojie
 */
public class HeapSort {

	/**
	 * heapAdjust方法 假设从start到end范围内的元素构成的堆除堆顶元素（此处为start处的元素）外其余均满足堆的特性
	 * @param source
	 * @param start 开始位置 --
	 * @param end 结束位置 --
	 */
	public static void heapAdjust(Integer[] source,int start,int end){
		int parent = start; //父节点的数组位
		int length = end - start + 1;
		int lChild = 2 * (parent + 1) - 1; //左孩子的数组位

		while (lChild < end){
			int child = lChild;
			int rChild = lChild + 1;
			//比较两个孩子，取较大的一个
			if(rChild < end && source[rChild] > source[lChild]){
				child = rChild;
			}

			//若父亲比较大的一个孩子大，直接结束
			if(source[parent] > source[child]){
				break;
			}

			//否则交换父亲和较大的一个孩子
			int temp = source[child];
			source[child] = source[parent];
			source[parent] = temp;

			parent = child;
			lChild = 2 * (parent + 1) - 1;
		}
	}

	public static void initHeap(Integer[] source){
		int length = source.length;

		//从第一个非叶子节点开始即可
		for (int i = length / 2; i >= 0; i --){
			heapAdjust(source,i,length - 1);
		}
	}

	public static void heapSort(Integer[] source){
		initHeap(source);

		for (int m : source){
			System.out.print(m + " ");
		}
		System.out.println();

		for(int i = source.length - 1; i > 0; i --){
			int temp = source[0];
			source[0] = source[i];
			source[i] = temp;

			heapAdjust(source,0,i);
			for (int m : source){
				System.out.print(m + " ");
			}
			System.out.println();

		}
	}

	public static void main(String[] args){
		Integer[] integers = new Integer[TestData.INTEGERS.length];
		System.arraycopy(TestData.INTEGERS,0,integers,0,integers.length);

		long time1 = System.nanoTime();
		heapSort(integers);
		long time2 = System.nanoTime();
		long time = time2 - time1;

		for (Integer integer : integers){
			System.out.print(integer + " ");
		}
		System.out.println("\n总用时：" + time);
	}

}
