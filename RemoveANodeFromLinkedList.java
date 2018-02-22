
public class RemoveANodeFromLinkedList {

	
	public static ListNode removeNode(ListNode x, int y) {
		ListNode head = null;
		ListNode temp = null;
        head = temp =x;
		while(x.val!=y & x!=null) {
			temp = x;
			x = x.next;
		}
		
		temp.next = x.next;
		while (head!=null)
        {
    		System.out.println(head.val);
            head = head.next;
        }
     return head ;
		
		
	}
	
	
	
	
		
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(7);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
	
		removeNode(l1, 6);
	}
}
