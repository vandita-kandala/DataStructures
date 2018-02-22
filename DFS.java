import java.util.ArrayList;
import java.util.Stack;

public class DFS {
	public ArrayList<ArrayList<Integer>> dfs(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int s = 0;
		ArrayList<Integer> alist = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> finallist = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> sumvalue = new Stack<Integer>();
		if(root == null){
			return null;
		}
		stack.push(root);
		s = root.val;
		sumvalue.push(s);
		alist.add(root.val);
		int len = 0;
		while(!stack.isEmpty()){
			TreeNode node = stack.peek();
			if(node.left == null && node.right == null){
				
				if(s==sum){
					finallist.add(alist);
					alist = new ArrayList<Integer>();
				}
				else{
					stack.pop();
					s = sumvalue.pop();
					len = alist.size();
					alist.remove(len-1);
				}
			}
			if(node.left!=null){
				stack.push(node.left);
				sumvalue.push(node.left.val + s);
				alist.add(node.left.val);
				node.left=null;
			}
			else{
				if(node.right!=null){
					stack.push(node.right);
					sumvalue.push(node.right.val+s);
					alist.add(node.right.val);
					node.right=null;
				}
			}
		}

		return finallist;
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
		DFS obj = new DFS();
		System.out.println(obj.dfs(t1, 22));
	}
}
