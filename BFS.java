import java.util.LinkedList;

public class BFS {
	
	public boolean bfs(TreeNode root, int sum) {
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<Integer> queue2 = new LinkedList<Integer>();
		if(root == null){
			return false;
		}
		queue1.push(root);
		queue2.push(root.val);
		while(!queue1.isEmpty()){
			TreeNode node = queue1.poll();
			int finalsum = queue2.poll();
			
			if(node.left!=null){
				queue1.add(node.left);
				queue2.add(node.left.val+finalsum);
			}
			if(node.right!=null){
				queue1.add(node.right);
				queue2.add(node.right.val+finalsum);
			}
			if(node.left == null && node.right == null && finalsum == sum){
				return true;
			}
		}

		return false;
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
		BFS obj = new BFS();
		System.out.println(obj.bfs(t1, 7));

	}

}
