package algorithm;

import java.util.*;

/**
 * @author Lichaojie
 * @version 2018/8/9 10:44
 *
 * 1.排序算法
 * @see algorithm.sort.BubbleSort
 * @see algorithm.sort.MergeSort
 * @see algorithm.sort.QuickSort
 * @see algorithm.sort.HeapSort
 *
 * 2.二叉树相关
 * @see algorithm.binarytree.BinaryTree
 * @see oj.nk.二叉树的镜像.Solution18
 * @see oj.nk.对称的二叉树.Main
 * @see oj.nk.二叉树的深度.Main
 * @see oj.nk.二叉树的下一个节点.Main
 * @see oj.nk.重建二叉树.Solution4
 * @see oj.nk.二叉树中和为某一值的路径.Solution24
 * @see oj.nk.树的子结构.Solution17
 *
 * 3.二分搜索
 * @see algorithm.binarysearch.BinarySearch
 *
 * 4.链表相关
 * @see oj.nk.反转链表.Solution15
 * @see oj.nk.链表中倒数第k个数.Solution14
 * @see oj.nk.链表中环的入口节点.Main
 * @see oj.nk.合并两个排序的链表.Solution16
 * @see oj.nk.复杂链表的复制.Main
 * @see oj.nk.从尾到头打印链表.Solution3
 *
 * 5.栈相关
 * @see oj.nk.两个栈实现队列.Solution5
 * @see oj.nk.包含min函数的栈.Solution20
 * @see oj.nk.栈的压入$弹出序列.Solution21
 * @see algorithm.stack.栈排序.Main
 * @see algorithm.stack.栈的逆序.Main
 *
 * 6.生产者&消费者
 * @see common.thread.produce$consume.Storage1   wait/notify/notifyAll
 * @see common.thread.produce$consume.Storage2   await/signal/signalAll
 *
 * 7.设计模式（单例）
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

