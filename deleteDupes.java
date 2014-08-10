
public class deleteDupes {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode newHead = head;
	        ListNode first = head;
	        ListNode cur = first != null? first.next: null;
	        ListNode curPrev = first;
	        while(cur!= null){
	            if (first.val == cur.val){
	                curPrev.next = cur.next;
	                cur = cur.next;
	            }
	            else {
	                first = cur;
	                curPrev = cur;
	                cur = cur.next;
	            }
	        }
	        return newHead;
	        
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
