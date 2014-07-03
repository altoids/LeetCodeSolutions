
public class SortList {
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode sortList(ListNode head) {
	    
        //find mid and end 
        ListNode leftlist = null;
        ListNode rightlist = null;
        ListNode midNode = null;
        if (head == null || head.next == null)
        {
            //single element, sorted.
            return head;
        }


        midNode = GetMiddleNode(head);
        rightlist = (midNode == null) ? null : midNode.next;
        //terminate the left list, the right list should already be terminated.
        midNode.next = null;

        leftlist = sortList(head);
        rightlist = sortList(rightlist);
        return MergeLists(leftlist, rightlist);

    }

    //find the middle element
    private ListNode GetMiddleNode(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null)
            return head;

        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //merge two singly linked sorted lists, non-recursive
    private static ListNode MergeLists(ListNode leftlist, ListNode rightlist)
    {
        ListNode a = null;
        ListNode newhead = null;

        while (leftlist != null && rightlist != null)
        {
            if (leftlist.val <= rightlist.val)
            {
                if (a == null)
                {
                    a = leftlist;
                    newhead = a;
                }
                else
                {
                    a.next = leftlist;
                    a = a.next;
                }
                leftlist = leftlist.next;
            }
            else
            {
                if (a == null)
                {
                    a = rightlist;
                    newhead = a;
                }
                else
                {
                    a.next = rightlist;
                    a = a.next;
                }
                rightlist = rightlist.next;
            }

        }

        if (leftlist == null && rightlist != null)
        {
            if (a == null)
                newhead = rightlist;
            else
                a.next = rightlist;
        }
        if (rightlist == null && leftlist != null)
        {
            if (a == null)
                newhead = leftlist;
            else
                a.next = leftlist;
        }

        return newhead;

    }
}
