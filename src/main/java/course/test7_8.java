package course;

/**
 * TestProject course
 *
 * @author Lichaojie
 * @version 2018/4/3 21:40
 */
public class test7_8 {
	public int getHeight(TreeNode head,int level,boolean[] res){
		if(head == null){
			return level;
		}

		int lh = getHeight(head.left,level + 1,res);
		if(!res[0]){
			return level;
		}

		int rh = getHeight(head.right,level + 1,res);
		if(!res[0]){
			return level;
		}

		if(Math.abs(lh - rh) > 1){
			res[0] = false;
		}

		return Math.max(lh,rh);
	}

	public boolean isBalence(TreeNode head){
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head,1,res);
		return res[0];
	}
}
