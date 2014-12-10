/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 */
import java.util.*;

public class MergeKLists {
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	 
	public class PqComparator implements Comparator<ListNode> {
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
        ListNode result = null;
        ListNode tail = result;
        boolean done = false;
        int k = lists.size();
        Comparator<ListNode> cp = new PqComparator();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, cp);
        double a = 12.e+10;
        Character c;
        c.
        
        while (!done && lists.size() > 0) {
            int min = 0;
            for (int i = 0; i<lists.size(); i++) {
                if (lists.get(i) != null) {
                	// this list isnt empty yet
                	if (lists.get(min) == null) {
                		min = i;
                		continue;
                	}
                	if (lists.get(min).val > lists.get(i).val)
                		min = i;
                }
            }
            if (min == 0 && lists.get(min) == null) {
            	done = true;
            	continue;
            }
            if (tail == null) {
            	result = lists.get(min);
            	tail = result;
            }else {
            	tail.next = lists.get(min);
            	tail = tail.next;
            }
            lists.set(min, lists.get(min).next);
            tail.next = null;
        }
        return result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKLists mkl = new MergeKLists();
		Random rm = new Random();
		
		List<ListNode> lists = new ArrayList<ListNode>();
		for (int i = 0; i<100000; i++) {
			int val = rm.nextInt();
			ListNode ln = mkl.new ListNode(val);
			lists.add(ln);
		}
		mkl.mergeKLists(lists);

	}

}
