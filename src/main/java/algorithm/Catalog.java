package algorithm;

import java.util.*;

/**
 * @author Lichaojie
 * @version 2018/8/9 10:44
 *
 * 1.�����㷨
 * @see algorithm.sort.BubbleSort
 * @see algorithm.sort.MergeSort
 * @see algorithm.sort.QuickSort
 * @see algorithm.sort.HeapSort
 *
 * 2.���������
 * @see algorithm.binarytree.BinaryTree
 * @see oj.nk.�������ľ���.Solution18
 * @see oj.nk.�ԳƵĶ�����.Main
 * @see oj.nk.�����������.Main
 * @see oj.nk.����������һ���ڵ�.Main
 * @see oj.nk.�ؽ�������.Solution4
 * @see oj.nk.�������к�Ϊĳһֵ��·��.Solution24
 * @see oj.nk.�����ӽṹ.Solution17
 *
 * 3.��������
 * @see algorithm.binarysearch.BinarySearch
 *
 * 4.�������
 * @see oj.nk.��ת����.Solution15
 * @see oj.nk.�����е�����k����.Solution14
 * @see oj.nk.�����л�����ڽڵ�.Main
 * @see oj.nk.�ϲ��������������.Solution16
 * @see oj.nk.��������ĸ���.Main
 * @see oj.nk.��β��ͷ��ӡ����.Solution3
 *
 * 5.ջ���
 * @see oj.nk.����ջʵ�ֶ���.Solution5
 * @see oj.nk.����min������ջ.Solution20
 * @see oj.nk.ջ��ѹ��$��������.Solution21
 * @see algorithm.stack.ջ����.Main
 * @see algorithm.stack.ջ������.Main
 *
 * 6.������&������
 * @see common.thread.produce$consume.Storage1   wait/notify/notifyAll
 * @see common.thread.produce$consume.Storage2   await/signal/signalAll
 *
 * 7.���ģʽ��������
 * @see algorithm.Singleton.Main
 *
 * 8.LRU
 * @see algorithm.cache.LRUCache
 *
 * 9.DeadLock
 * @see common.thread.DeadLock
 *
 * 10.DB Pool
 * @see common.db.Pool
 *
 * 11.JosephCircle
 * @see algorithm.JosephCircle.JosephCircle
 *
 */
public class Catalog {
	public static void main(String[] args){
		Comparator<Integer> comparator = (Integer o1, Integer o2) -> {
			if(o1 < o2){
				return -1;
			}else if (o1.equals(o2)) {
				return 0;
			}else{
				return 1;
			}
		};

	}

}

