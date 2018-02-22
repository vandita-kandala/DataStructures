import java.util.HashMap;
import java.util.Map;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
      
      public String toString() {
			return " "+label;
		}
		
  };

public class DeepCopyLinkedList {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
            return null;
        }
        
        final Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            final RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
            
        }
        System.out.print(map.get(head.next.next.random).toString());
        return map.get(head);
	        
	}
	
public static void main(String args[]){
	

	RandomListNode l1 = new RandomListNode(1);
	RandomListNode l2 = new RandomListNode(2);
	RandomListNode l3 = new RandomListNode(3);
	RandomListNode l4 = new RandomListNode(4);
	RandomListNode l5 = new RandomListNode(5);
		
	l1.next =l2;
	l2.next=l3;
	l3.next=l4;
	l4.next=l5;
	l3.random = l2;
	l5.random=l4;
	
		
		copyRandomList(l1);

		
	}
}
