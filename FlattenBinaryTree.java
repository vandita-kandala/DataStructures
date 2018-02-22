import java.util.LinkedList;
import java.util.Stack;

public class FlattenBinaryTree {
	public Stack<Integer> flattenBT(TreeNode root){
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> ll = new Stack<Integer>();
		
		if(root==null){
			return null;
		}
		
		stack.push(root);
		ll.add(root.val);
		while(!stack.isEmpty()){
			TreeNode node = stack.peek();
			if(node.left!=null){
				stack.push(node.left);
				ll.add(node.left.val);
				node.left=null;
			}
			else{
				stack.pop();
				if(node.right!=null){
					stack.push(node.right);
					ll.add(node.right.val);
					node.right=null;
				}
				
			}
			
		}
		return ll;
		
		    //1
	//2		        //6
//3	  //4		 //7    //8
		 //5   //9
				   //10
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
		FlattenBinaryTree obj = new FlattenBinaryTree();
		System.out.println(obj.flattenBT(t1));
	}
}
