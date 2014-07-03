import java.util.*;

public class LinkedListCycle {

	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
	public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        if (head != null)
            fast = head.next;
        while (slow != null && fast != null && fast.next != null && fast != slow)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast == slow && fast != null && slow != null)
            return true;
        else
            return false;
        
    }
}
