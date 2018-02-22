import java.util.ArrayList;
import java.util.Stack;

public class KthSmallest {

	public Integer findkthSmallest(TreeNode root, int k){
		ArrayList<Integer> alist = new ArrayList<Integer>();		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null){
			return 0;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.peek();
			if(node.left!=null){
				stack.push(node.left);
				node.left = null;
			}
			else{
				stack.pop();
				alist.add(node.val);
				if(node.right!=null){
					stack.push(node.right);
					node.right = null;
				}
			}
		}
		return alist.get(k-1);
	}
	public static void main(String args[]){
		TreeNode t1 = new TreeNode(50);
		TreeNode t2 = new TreeNode(40);
		TreeNode t3 = new TreeNode(60);
		TreeNode t4 = new TreeNode(35);
		TreeNode t5 = new TreeNode(45);
		TreeNode t6 = new TreeNode(55);
		TreeNode t7 = new TreeNode(65);
		TreeNode t8 = new TreeNode(36);
		TreeNode t9 = new TreeNode(54);
		TreeNode t10 = new TreeNode(67);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.right = t8;
		t3.left = t6;
		t3.right = t7;
		t7.right = t10;
		t6.left = t9;
		
		KthSmallest obj = new KthSmallest();
		System.out.println(obj.findkthSmallest(t1,10));
		System.out.println("hey");
		
		
	}
}
