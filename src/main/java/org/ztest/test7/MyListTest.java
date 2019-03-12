package org.ztest.test7;


/**
 * org.test.test22
 * Created on 2017/12/5
 *
 * @author Lichaojie
 *
 * µ•œÚ¡¥±Ì
 */
public class MyListTest {

	private Node first;

	private Node last;

	private int size;

	public MyListTest(){
		this.first = this.last = null;
		this.size = 0;
	}

	public void add(Object item){
		Node node = new Node(item,null);
		if(last == null){
			this.first = this.last = node;
		}else {
			this.last.next = node;
			this.last = node;
		}
		size ++;
	}

	public void add(int index,Object item){

	}

	public void remove(Object item){
		if(item != null){
			if(item.equals(first.item)){
				first = first.next;
				return;
			}

			Node pre = first;
			for (Node node = first.next; node != null; node = node.next){
				if(item.equals(node.item)){
					pre.next = node.next;
					if(node == last){
						last = pre;
					}
					return;
				}
				pre = pre.next;
			}
		}
	}

	public void remove(int index){

	}

	public void inverse(){
		Node l = first;
		Node r = first.next;
		last = first;
		last.next = null;
		while (r != null){
			Node next = r.next;
			r.next = l;
			l = r;
			r = next;
		}
		first = l;
	}

	@Override
	public String toString(){
		String str = "";
		for (Node node = first; node != null; node = node.next){
			str += (node.item.toString() + " ");
		}
		return str;
	}

	public static void main(String[] args){
		MyListTest list = new MyListTest();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.toString());
		list.inverse();
		System.out.println(list.toString());
	}





	private class Node{
		Object item;
		Node next;

		Node(){}

		Node(Object item,Node next){
			this.item = item;
			this.next = next;
		}
	}
}
