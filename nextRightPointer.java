/*
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
// this solution can fit both "find next right node I" and "find next right node II"
import java.util.*;
public class nextRightPointer {
	 public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
	public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        LinkedList<Integer> qLevel = new LinkedList<Integer>();
        TreeLinkNode tnodetemp = null;
        TreeLinkNode prevNode = null;
        q.add(root);
        qLevel.add(1);
        int prevLevel = 0;
        while (q.size() != 0){
            tnodetemp = q.removeFirst();
            if (qLevel.getFirst() <= prevLevel){
                prevNode.next = tnodetemp;
            }
            prevLevel = qLevel.removeFirst();
            prevNode = tnodetemp;
            tnodetemp.next = null;
            if (tnodetemp.left != null){
                q.add(tnodetemp.left);
                qLevel.add(prevLevel + 1);
            }
            if (tnodetemp.right != null){
                q.add(tnodetemp.right);
                qLevel.add(prevLevel + 1);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
