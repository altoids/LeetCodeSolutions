
import java.util.*;

public class LRUCache {
    
    class ListNode {
	      int val;
	      int key;
	      ListNode next;
	      ListNode prev;
	      ListNode(int inputkey, int inputval) {
	          val = inputval;
	          key = inputkey;
	          next = null;
	          prev = null;
	      }
	  }
	class myLinkedList{
		ListNode head;
		ListNode tail;
		myLinkedList(){
			head = null;
			tail = null;
		}
		void remove(ListNode node)
		{
			if (node.prev != null)
				node.prev.next = node.next;
			else
				head = node.next; //we are at head
			if (node.next != null)
				node.next.prev = node.prev;
			else
				tail = node.prev; //we are at tail
		}
		void add(ListNode node)
		{
			if (node == null)
				return; // no op on null node param
			//add to the end of the list
			if (tail != null)
			{
				node.next = tail.next;
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			else
			{
				//tail and head should be both null here.
				tail = node;
				head = node;
			}
		}
	}
	
	HashMap<Integer, ListNode> map;
	myLinkedList qu;
    int size = 0;
	public LRUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        qu = new myLinkedList();
        size = capacity;
    }
    
    public int get(int key) {
        int value = -1;
        ListNode node = null;
    	if (map.containsKey(key))
        {
    		node = map.get(key);
    		qu.remove(node);
        	qu.add(node);
        	value =  node.val;
        }

    	return value;
    }
    
    public void set(int key, int value) {
    	
        ListNode node = null;
    	if (map.containsKey(key))
    	{
    		node = map.get(key);
    		qu.remove(node);
    		node.val = value;
    		node.key = key;
    		map.put(key, node);
    		
    	}
    	else
    	{
    		if (size <= map.size())
            {
    			// we need to remvoe elements to make room
    			node = qu.head;
            	qu.remove(node);
            	map.remove(node.key);
            }
    		node = new ListNode (key, value);
    		map.put(key, node);
    	}
    	qu.add(node);
           	
    }
}
