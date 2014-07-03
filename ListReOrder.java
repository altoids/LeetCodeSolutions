

public class ListReOrder {
	
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public void reorderList(ListNode head) {
        ListNode cur = head;
        ListNode last = head;
        ListNode last2nd = head;
        
        while (cur != null && cur.next!=null)
        {
            last = cur;
            while (last!=null && last.next !=null)
            {
                last2nd = last;
                last = last.next;
            }
            //we find the last node
            if (cur.next != last)
            {
            	last.next = cur.next;
               	cur.next = last;
               	
               	last2nd.next = null;
            }
            cur = cur.next.next;
        }
        
        return;
        
    }
	
	public void reorderList2(ListNode head) {
		if (head == null)
			return;
		ListNode midnode = findMid(head);
		ListNode curnode = head;
		//break up into two lists
		while (curnode.next != midnode)
			curnode = curnode.next;
		curnode.next = null; //break it up here.
		
		ListNode head2 = reverseList(midnode);
		head = mergeTwoLinkedLists(head, head2);
		return;
	}
	
	public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast !=null & fast!=head)
        {
        	//it's an odd number of nodes, move slow node once more
        	slow = slow.next;
        }
        
        return slow;
        
    }
	
	public ListNode reverseList(ListNode head)
	{
		ListNode nextnode = head;
		ListNode nextnextnode = head;
		ListNode resulthead = head;
		while (nextnode != null )
		{
			
			if (resulthead == head)
			{
				nextnode = resulthead.next;
				//make .next null
				resulthead.next = null;
			}
				
			if (nextnode !=null)
			{
				nextnextnode = nextnode.next;
				nextnode.next = resulthead;
				resulthead = nextnode;
				nextnode = nextnextnode;
			}
			
		}
		return resulthead;
	}
	
	public ListNode mergeTwoLinkedLists(ListNode head1, ListNode head2)
	{
		//merge two singly linked lists, one element from each list every time
		//assuming list1 is always longer or same size as list two.
		//merging list2 into list1
		ListNode curnode1 = head1;
		ListNode curnode2 = head2;
		ListNode nextnode1 = head1;
		ListNode nextnode2 = head2;
		
		while (curnode1 != null  && curnode2 != null)
		{
			nextnode1 = curnode1.next;
			nextnode2 = curnode2.next;
			curnode1.next = curnode2;
			curnode2.next = nextnode1;
			curnode1 = nextnode1;
			curnode2 = nextnode2;
		}
		return head1;
	}
}
