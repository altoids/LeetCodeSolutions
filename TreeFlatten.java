/*
 * Flatten Binary Tree to Linked List Total Accepted: 19543 Total Submissions: 69643 My Submissions
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.
 */
public class TreeFlatten {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        TreeNode cur = root.left;
        while (cur != null && cur.right != null){
            cur.left = null;
            cur = cur.right;
        }
        flatten(root.right);
        if (cur != null){
            cur.right = root.right;
            cur.left = null;
        }
        if (root.left != null)
            root.right = root.left;
        root.left = null;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
