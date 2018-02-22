import java.util.LinkedList;

public class LongestConsecutiveSequence_BT {
	public Integer longestSequence(TreeNode root){
		int leftsize =1;
		int rightsize=1;
		int size = Math.max(leftsize,rightsize);
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
	    LinkedList<Integer> sizeQueue = new LinkedList<Integer>();
	 
	    if(root == null){
	    	return 0;
	    }
		
	    nodeQueue.add(root);
	    sizeQueue.add(size);
	    while(!nodeQueue.isEmpty()){
	    	TreeNode node = nodeQueue.poll();
	    	size = sizeQueue.poll();
	    	if(node.left!=null){
	    		
	    		if(node.val==node.left.val-1){
	    			leftsize++;
	    		}
	    		else{
	    			leftsize = 1;
	    		}
	    		nodeQueue.add(node.left);
	    		sizeQueue.add(leftsize);
	    	}
	    	if(node.right!=null){
	    		
	    		if(node.val==node.right.val-1){
	    			rightsize++;
	    		}
	    		else{
	    			rightsize = 1;
	    		}
	    		nodeQueue.add(node.right);
	    		sizeQueue.add(rightsize);
	    	}
	    }
	    size = Math.max(leftsize, rightsize);
		return size;
		
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
		LongestConsecutiveSequence_BT obj = new LongestConsecutiveSequence_BT();
		System.out.println(obj.longestSequence(t1));
	}

}
