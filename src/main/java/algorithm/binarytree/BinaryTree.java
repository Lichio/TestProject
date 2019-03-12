package algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TestProject algorithm.binarytree
 *
 * ��������������� �� ������ȱ���DFS
 *
 * @author Lichaojie
 * @version 2018/3/2 17:45
 */
public class BinaryTree {

	/**
	 * ������� �ݹ�
	 * @param root
	 */
	public void preorder1(TreeNode root){
		if(root != null){
			System.out.print(root.val + " ");
			preorder1(root.left);
			preorder1(root.right);
		}
	}

	/**
	 * ������� �ݹ�
	 * @param root
	 */
	public void inorder1(TreeNode root){
		if(root != null){
			inorder1(root.left);
			System.out.print(root.val + " ");
			inorder1(root.right);
		}
	}

	/**
	 * ������� �ݹ�
	 * @param root
	 */
	public void postorder1(TreeNode root){
		if(root != null){
			postorder1(root.left);
			postorder1(root.right);
			System.out.print(root.val + " ");
		}
	}



	/**
	 * ������� �ǵݹ�
	 * @param root
	 */
	public void preorder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.empty()){
			while (node != null){
				stack.push(node);
				System.out.print(node.val + " ");
				node = node.left;
			}
			if(!stack.empty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}

	/**
	 * ������� �ǵݹ�
	 * @param root
	 */
	public void inorder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (node != null || !stack.empty()){
			while (node != null){
				stack.push(node);
				node = node.left;
			}
			if(!stack.empty()){
				node = stack.pop();
				System.out.print(node.val + " ");
				node = node.right;
			}
		}
	}

	/**
	 * ������� �ǵݹ�
	 * @param root
	 */
	public void postorder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		List<TreeNode> allList = new ArrayList<>();
		List<TreeNode> list = new ArrayList<>();
		TreeNode node = root;
		int flag = 0;
		int rflag = 0;
		while (node != null || !stack.empty()){
			while (node != null){
				stack.push(node);
				list.add(node);
				allList.add(node);
				node = node.left;
			}
			//System.out.println("��ǰջ��Ԫ�� : " + stack.peek().val);
			node = stack.peek();
			if(node.right == null){
				System.out.print(node.val + " ");
				stack.pop();
				list.remove(list.size() - 1);
				node = stack.peek();
			}
			node = node.right;
			while (allList.contains(node) && !list.contains(node)){
				node = stack.peek();
				System.out.print(node.val + " ");
				stack.pop();
				list.remove(list.size() - 1);
				if(!stack.empty()){
					node = stack.peek();
					node = node.right;
				}else {
					node = null;
					break;
				}
			}

		}
	}

	/**
	 * ������� �ǵݹ� ��ʹ������ջʵ�֣�
	 * @param root
	 */
	public void postorder3(TreeNode root){
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		s1.push(root);
		while (!s1.isEmpty()){
			TreeNode cur = s1.pop();
			s2.push(cur);

			if(cur.left != null) s1.push(cur.left);
			if(cur.right != null) s1.push(cur.right);
		}

		//s2.forEach(n -> System.out.print(n.val + " "));
		while (!s2.isEmpty()){
			System.out.print(s2.pop().val + " ");
		}
	}


	/**
	 * ������� �ǵݹ� ��ʹ��һ��ջʵ�֣�
	 * @param root
	 */
	public void postorder4(TreeNode root){
		Stack<TreeNode> s = new Stack<>();
		s.push(root);

		TreeNode h = root;
		TreeNode c = null;

		while (!s.isEmpty()){
			c = s.peek();
			if(c.left != null && h != c.left && h != c.right){
				s.push(c.left);
			}else if (c.right != null && h != c.right){
				s.push(c.right);
			}else {
				c = s.pop();
				h = c;
				System.out.print(h.val + " ");
			}
		}
	}

	/**
	 * �������
	 * @param root
	 */
	public static void bfs(TreeNode root){
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()){
			TreeNode node = list.removeFirst();
			if(node.left != null) list.addLast(node.left);
			if(node.right != null) list.addLast(node.right);
			System.out.print(node.val + " ");
		}
	}

	public static void  main(String[] args){
		BinaryTree tree = new BinaryTree();
		TreeNode root = BinaryTree.getBinaryTree();

		System.out.println("������� ��");
		tree.preorder1(root);
		System.out.println();
		tree.preorder2(root);
		System.out.println();

		System.out.println("������� ��");
		tree.inorder1(root);
		System.out.println();
		tree.inorder2(root);
		System.out.println();

		System.out.println("������� ��");
		tree.postorder1(root);
		System.out.println();
		tree.postorder4(root);
		System.out.println();

		System.out.println("������� ��");
		bfs(root);
	}

	
	
	
	public static TreeNode getBinaryTree(){
		List<TreeNode> list = new ArrayList<>(10);
		for (int i = 1 ; i <= 10; i ++){
			TreeNode node = new TreeNode(i);
			node.left = null;
			node.right = null;
			list.add(node);
		}

		list.get(0).left = list.get(1);
		list.get(0).right = list.get(2);

		list.get(1).left = list.get(3);
		list.get(1).right = list.get(4);

		list.get(2).left = list.get(5);
		list.get(2).right = list.get(6);

		list.get(3).right = list.get(7);

		list.get(5).left = list.get(8);
		list.get(5).right = list.get(9);

		return list.get(0);
	}
}
