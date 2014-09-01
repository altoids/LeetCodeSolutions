import java.util.*;

/*
 * Convert Sorted List to Binary Search Tree Total Accepted: 17517 Total Submissions: 64305 My Submissions
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
        	return null;
        // find mid point of the sorted list
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prevslow = slow;
        while (slow != null && fast != null){
        	prevslow = slow;
        	slow = slow.next;
        	fast = fast.next;
        	if (fast != null)
        		fast = fast.next;
        }
        
        // make mid point the root of this subtree
        TreeNode root = new TreeNode(slow.val);
        
        //seperate left part of the list and call recursively, assign the return to left tree
        if (prevslow == slow)
        	head = null;
        else
        	prevslow.next = null;
        ListNode rightlist = slow.next;
        ListNode leftlist = head;
        
        root.left = sortedListToBST(leftlist);
        //seperate right part of the list and call recursively, assign the return to right tree
        root.right = sortedListToBST(rightlist);
        // return root node
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();
		ListNode head = null;
		ListNode cur = null;
		while(sIn.hasNext()){
			int newNum = sIn.nextInt();
			if (head == null){
				//first node
				head = c.new ListNode(newNum);
				cur = head;
			}else{
				cur.next = c.new ListNode(newNum);
				cur = cur.next;
			}
			cur.next = null;
		}
		printTree(c.sortedListToBST(head));
	}
	private static void printTree(TreeNode root){
		//inordertravel, it should print a sorted number list
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.val + " ");
		printTree(root.right);
	}

}
