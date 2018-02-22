import java.util.ArrayList;
import java.util.LinkedList;

public class Levelorder {
	public ArrayList<ArrayList<Integer>> levelorder(TreeNode root) {
		ArrayList<ArrayList<Integer>> finallist = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> alist = new ArrayList<Integer>();
		
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	    LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	    
	    if(root == null){
	    	return finallist;
	    }
	    
	    current.add(root);
	    
	    while(!current.isEmpty()){
	    	TreeNode node = current.remove();
	    	if(node.left!=null){
	    		next.add(node.left);
	    		node.left=null;
	    	}
	    	if(node.right!=null){
	    		next.add(node.right);
	    		node.right=null;
	    	}
	    	alist.add(node.val);
	    	if(current.isEmpty()){
	    		finallist.add(alist);
	    		current = next;
	    		alist = new ArrayList<Integer>();
	    		next = new LinkedList<TreeNode>();
	    	}
	    }
		
		return finallist;
	}
	public static void main(String args[]){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		
		t1.left = t2;
		t2.left = t3;
		t2.right = t4;
		t4.right = t5;
		t1.right = t6;
		t6.left = t7;
		t6.right = t8;
		t7.left = t9;
		t9.right = t10;
		Levelorder obj = new Levelorder();
		System.out.println(obj.levelorder(t1));
	}
}
