
class ListNode{
		int val;
		ListNode next;
		
		ListNode(int x){
			val = x;
			next = null;
		}
		
	}

public class LinkedListAddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null;
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);
        
        while(ln1 != null || ln2 != null || carry != 0) {
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
            carry = sum / 10;
            remainder = sum % 10;
            node.next = new ListNode(remainder);
            node = node.next;
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
           //System.out.println(node.val);
        }
        while (head.next!=null)
          {
      		System.out.println(head.next.val);
              head = head.next;
          }
       return head.next ;
    }
	
	
	public static void main(String args[]){
		
		
		ListNode l1 = new ListNode(3);
		
		ListNode l2 = new ListNode(4);
		l1.next = l2;
		ListNode l3 = new ListNode(2);
		l2.next = l3;
		ListNode l4 = new ListNode(7);
		l3.next = l4;
		ListNode m1 = new ListNode(4);
		ListNode m2 = new ListNode(6);
		m1.next = m2;
		ListNode m3 = new ListNode(5);
		m2.next = m3;
		
		addTwoNumbers(l1,m1);

		
	}
	
	
}
