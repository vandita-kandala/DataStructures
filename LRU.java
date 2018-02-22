import java.util.HashMap;

class Node{
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRU {
	int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
 
    public LRU(int capacity) {
        this.capacity = capacity;
    }  
    public int get(int key){
    		if(map.containsKey(key)){
    			Node mapNode = map.get(key);
    			int value = mapNode.value;
    			Node x = new Node(key,value);
				map.remove(key);
    		//	mapNode.value=x.value;
    			if(head.next==null){
    				head.next=x;
    				head = head.next;
    				end=x;
    				head.pre=null;
    				map.put(key, x);
    			}
    			else if(head.key==mapNode.key &&head.next!=null){
    				head = head.next;
    				head.pre=null;
    				end.next=x;
    				x.pre=end;
    				end=x;
    				map.put(key, x);

    			}
    			else if(end.key==mapNode.key && end.pre!=null){
    				end.value=x.value;


    			}
    			else{
    				Node temp = mapNode.next;
    				Node temp1 = mapNode.pre;
    				temp1.next=temp;
    				temp.pre=temp1;
    				end.next=x;
    				x.pre=end;
    				end=x;
    				map.put(key, x);

    			}
    			
    			return mapNode.value;
    		}
    		
    	
    	return -1;
		
    }
    
	public void set(int key, int value){
		
	if(!map.containsKey(key)){
		Node x = new Node(key,value);
		map.put(key, x);
		if(map.size()>capacity){
			map.remove(head.key);

			if(head.next!=null){
				head=head.next;
				head.pre=null;
				
				end.next=x;
				x.pre=end;
				end=x;	
			}
			else{
				head.next=x;
				x.pre=null;
				head=x;
			}		
		}
		else{
			if(head==null){
				head=x;
				end=x;
			}
			else if(head.next==null && head!=null){
				head.next=x;
				x.pre=head;
				end=x;

			}
			else{
				end.next=x;
				x.pre=end;
				end=x;
			}
		}
	}
	else{
		if(map.containsKey(key)){
			
			Node x = new Node(key,value);
			Node mapNode = map.get(key);
			mapNode.value=x.value;
			
			map.remove(key);

			if(head.key==mapNode.key && head.next==null){
				
				mapNode.next=x;
				head.next=x;
				mapNode = head = end =x;
				mapNode.pre=null;
				head.pre=null;
				x.pre=null;
				map.put(key, x);
			}
			else if(head.key==mapNode.key && head.next!=null){
				head = head.next;
				head.pre=null;
				end.next=x;
				x.pre=end;
				end=x;
				map.put(key, x);

			}
			else if(end.key==mapNode.key && end.pre!=null){
				mapNode.value=x.value;
map.put(end.key, x);
			}
			else{
				
				//System.out.println("SCvdsfvdfv"+mapNode.value);
				Node temp = mapNode.next;
				Node temp1 = mapNode.pre;
				temp1.next=temp;
				temp.pre=temp1;
				end.next=x;
				x.pre=end;
				end=x;
				map.remove(mapNode.key);
				map.put(key, x);
				
			}
		}
	}
	}
	public void print(){
		while (head!=null)
	    {
			System.out.println(head.key+","+head.value);
	        head = head.next;
	    }
	}
	public static void main(String args[]){
		LRU obj=new LRU(2);
		System.out.println(obj.get(2));

		obj.set(2,6);
		System.out.println(obj.get(1));
		obj.set(1,5);
		obj.set(1,2);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));

		//2,6
		//1,2
		
		
		
		
		
//
//		obj.set(10,27);
//		obj.set(8,10);
//		
//		System.out.println(obj.get(8));
//		obj.set(6,29);
//		obj.set(1,9);
//		System.out.println(obj.get(6));
//		obj.set(10,7);
//		System.out.println(obj.get(1));
//		System.out.println(obj.get(2));
//		System.out.println(obj.get(13));
//		obj.set(8,30);
//		obj.set(1,5);
//		System.out.println(obj.get(1));
//
//		obj.set(13,2);
//
//		System.out.println(obj.get(12));


//		//obj.print();

	}
}




//capacity:2

//-1
//2,6 ->null
//-1
//2,6->1,2->null
//2
//6
//1,2->2,6->null




