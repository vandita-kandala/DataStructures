import java.util.Stack;

public class ValidatingBinaryTree {

	public Boolean validateBST(TreeNode root){
		Boolean valid = false;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root==null){
			return null;
		}
		
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node.left!=null){
				if(node.val<node.left.val){
					return false;
				}
				else{
					valid=true;
					stack.push(node.left);
				}
			}
			if(node.right!=null){
				if(node.val>node.right.val){
					return false;
				}
				else{
					valid=true;
					stack.push(node.right);
				}
			}
		}
		
		return valid;
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
		
		ValidatingBinaryTree obj = new ValidatingBinaryTree();
		System.out.println(obj.validateBST(t1));
	}
}
