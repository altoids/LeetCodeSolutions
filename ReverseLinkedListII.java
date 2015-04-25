/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
import java.util.*;

public class ReverseLinkedListII {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode midHead = null; // one element before m
		ListNode midTail = null; // element n + 1
		ListNode nElem = null; // element n
		ListNode cur = null; // current node
		ListNode prev = null; // node before cur
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode temp = null;
		dummy.next = head;
		cur = head;
		prev = dummy;
		
		for (int i = 1; i <= n; i++ ) {
			if (i <= m) {
				midHead = prev;
			}
			if (i == n) {
				midTail = cur.next; 
				nElem = cur;
			}
			temp = cur.next;
			if ( i >= m && i <= n) {
				// reverting in progress
				cur.next = prev;
			}
			prev = cur;
			cur = temp;
		}
		midHead.next.next = midTail;
		if (midHead == dummy)
			head = nElem;
		else
			midHead.next = nElem;
		return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1, 2, 3,  4, 5};
		ReverseLinkedListII rll = new ReverseLinkedListII();
		//build list
		ListNode head = null;
		ListNode newHead = null;
		ListNode cur = head;
		for (int i = 0; i< values.length ; i++) {
			if (i == 0) {
				// header
				head = rll.new ListNode(values[i]);
				cur = head;
			}
			else {
				ListNode newcur = rll.new ListNode(values[i]);
				cur.next = newcur;
				cur = newcur;
				
			}
				
		}
		
		newHead = rll.reverseBetween(head, 2, 5);
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
		
	}

}
