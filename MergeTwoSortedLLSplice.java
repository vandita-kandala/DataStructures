
public class MergeTwoSortedLLSplice {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
	    
//        while (mergeHead.next!=null)
//        {
//			System.out.println(mergeHead.val);
//            mergeHead.next = mergeHead.next;
//        }
       
//    while (head.next!=null)
//    {
//		System.out.println(head.next.val);
//        head.next = head.next.next;
//    }
        
    }
	
	public static void main(String args[]){
		
		ListNode l1 = new ListNode(2);
		
		ListNode l2 = new ListNode(3);
		l1.next = l2;
		ListNode l3 = new ListNode(4);
		l2.next = l3;
		
		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(5);
		m1.next = m2;
		ListNode m3 = new ListNode(10);
		m2.next = m3;
		
			
			System.out.println(mergeTwoLists(l1,m1));

			
		}
}
