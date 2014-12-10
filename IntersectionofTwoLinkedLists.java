/*
 * 
Intersection of Two Linked Lists
Total Accepted: 5252 Total Submissions: 19660

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class IntersectionofTwoLinkedLists {
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        if (pa == null || pb == null) {
            return null;
        }
        
        while (pa != null && pb != null && pa != pb) {
            pa = pa.next;
            pb = pb.next;
            if (pa == pb) return pa;
            if (pa == null) pa = headB;
            if (pb == null) pb = headA;
        }
        return pa;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
