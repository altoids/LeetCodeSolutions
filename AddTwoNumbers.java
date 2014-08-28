
public class AddTwoNumbers {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultcur = result;
        ListNode l1cur = l1;
        ListNode l2cur = l2;
        int carry = 0;
        
        while (l1cur != null || l2cur != null || carry == 1){
            int n1 = 0;
            int n2 = 0;
            if (l1cur != null){
                n1 = l1cur.val;
                l1cur = l1cur.next;
            }
            if (l2cur != null){
                n2 = l2cur.val;
                l2cur = l2cur.next;
            }
            
            int temp = n1+ n2 + carry;
            if (temp >= 10)
                carry = 1;
            else
                carry = 0;
            ListNode tempNode = new ListNode(temp % 10);
            if (resultcur != null){
                resultcur.next = tempNode;
                resultcur = resultcur.next;
            }else{
                //empty list
                result = tempNode;
                resultcur = tempNode;
            }
            
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
