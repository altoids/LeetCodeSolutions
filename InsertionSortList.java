
public class InsertionSortList {
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	
	public ListNode insertionSortList(ListNode head) {
        
        ListNode prev = head;
        ListNode cur = head;
        ListNode target = head;
        ListNode prevtarget = head;
        ListNode HeadNode = new ListNode(0);
        HeadNode.next = head;

        while (target != null)
        {
            
            cur = head; prev = HeadNode;
            boolean bInserted = false;
            while (cur != target && cur != null)
            {
                if (target.val >= cur.val)
                {
                    prev = cur;
                    cur = cur.next;
                }
                else
                {
                    prev.next = target;
                    prevtarget.next = target.next;
                    target.next = cur;
                    bInserted = true;
                    break;
                }
            }
            if (bInserted)
                target = prevtarget.next;
            else
            {
                prevtarget = target;
                target = target.next;
            }
            head = HeadNode.next;
        }

        return head;
}
}
