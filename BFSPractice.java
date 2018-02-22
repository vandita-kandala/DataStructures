import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSPractice {

	public ArrayList<Integer> bfs(TreeNode root, int sum) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> alist = new ArrayList<Integer>();
		if(root.val == sum) {
			alist.add(sum);
			return alist;
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.val == sum) {
				alist.add(node.val);
				return alist;
			}
			else {
				alist.add(node.val);
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
			
		}
		
		return alist;
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
		BFSPractice obj = new BFSPractice();
		System.out.println(obj.bfs(t1, 7));

	}
}
