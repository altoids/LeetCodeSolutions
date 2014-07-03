
import java.util.*;

public class CopyListwithRandomPointer {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		 };
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode resultHead = null;
        RandomListNode temp = null;
        RandomListNode cur = head;
        
        if (head == null)
            return null;
        //copy nodes, embedded them into the current list, each new node next to the old node
        while (cur != null)
        {
            temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        //navigate the 2x list, correct the random links
        cur = head;
        while (cur!= null)
        {
            temp = cur.random;
            if (temp == null)
            {
                cur.next.random = null;
            }
            else
            {
                cur.next.random = cur.random.next;
            }
            cur= cur.next.next;
        }
        //seperate the linked lists
        cur = head;
        resultHead = cur.next;
        while (cur!=null)
        {
            temp = cur.next;
            cur.next = cur.next.next;
            if (cur.next != null)
                temp.next = cur.next.next;
            else
                temp.next = null;
            cur = cur.next;
        }
        return resultHead;
    }
}
