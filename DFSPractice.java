import java.util.ArrayList;
import java.util.Stack;

public class DFSPractice {
	public ArrayList<Integer> dfs(TreeNode root, int sum) {

		ArrayList<Integer> alist = new ArrayList();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.val == sum) {
				alist.add(node.val);
				return alist;
			}
			alist.add(node.val);
			if(node.left!=null) {
				stack.push(node.left);
			}
			if(node.right!=null) {
				stack.push(node.right);
			}
		}
		
		return alist;
	}
	
	public static void main(String args[]){
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(5);
		TreeNode t10 = new TreeNode(1);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.left = t5;
		t3.right = t6;
		t4.left = t7;
		t4.right = t8;
		t6.left = t9;
		t6.right = t10;
		DFSPractice obj = new DFSPractice();
		System.out.println(obj.dfs(t1, 11));
	}
}
