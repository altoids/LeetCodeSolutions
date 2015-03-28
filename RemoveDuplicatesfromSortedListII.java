
public class RemoveDuplicatesfromSortedListII {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	 
	public ListNode deleteDuplicates(ListNode head) {
		ListNode lastTail = head;
		ListNode firstUnknown = head;
		
		while (firstUnknown != null) {
			ListNode cur = firstUnknown.next;
			while (cur!= null && cur.val == firstUnknown.val)
				cur = cur.next;
			if (firstUnknown.next == cur ) {
				// no dupe
				lastTail = firstUnknown;
				firstUnknown = cur;
			} else {
				// has dupe
				if (lastTail == head && lastTail == firstUnknown) {
					// fist time ever
					head = cur;
					lastTail = head;
				}
				else
					lastTail.next = cur;
				firstUnknown = cur;
			}
		}
		return head;
	        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1, 2, 2,  3};
		RemoveDuplicatesfromSortedListII rd = new RemoveDuplicatesfromSortedListII();
		
		//build list
		ListNode head = null;
		ListNode cur = head;
		for (int i = 0; i< values.length ; i++) {
			if (i == 0) {
				// header
				head = rd.new ListNode(values[i]);
				cur = head;
			}
			else {
				ListNode newcur = rd.new ListNode(values[i]);
				cur.next = newcur;
				cur = newcur;
				
			}
				
		}
		head = rd.deleteDuplicates(head);
		
		// print list
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
