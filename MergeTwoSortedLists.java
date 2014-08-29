/*
 * Merge Two Sorted Lists Total Accepted: 22519 Total Submissions: 67690 My Submissions
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1cur = l1;
        ListNode l2cur = l2;
        ListNode resultcur = null;
        ListNode result = null;
        ListNode temp = null;
        while(l1cur != null && l2cur!= null){
            if (l1cur.val <=l2cur.val){
                temp = l1cur;
                l1cur = l1cur.next;
            }
            else{
                temp = l2cur;
                l2cur = l2cur.next;
            }
            if(resultcur == null)
                result = temp;
            else
                resultcur.next = temp;
            resultcur = temp;
            temp.next = null;
        }
        if (l1cur != null)
            temp = l1cur;
        else
            temp = l2cur;
        if (temp != null)
            if (resultcur != null)
                resultcur.next = temp;
            else
                result = temp;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
