
import java.util.*;

public class LinkedListCycleII {
	
	class ListNode {
		      int val;
		     ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}

	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        
        do {
            if (fast == null || slow == null)
                return null; // no cycle since at leats one of them reaches the null end
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next; //one extra step is possible
            else
                return null; // still no cycle
        }while (fast != slow);
        
        if (fast == slow && fast != null && slow != null)
            {
                slow = head;
                while (slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        else
            return null;
    }
}

