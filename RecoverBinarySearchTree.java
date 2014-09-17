/*
 * Recover Binary Search Tree Total Accepted: 15651 Total Submissions: 66235 My Submissions
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class RecoverBinarySearchTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	TreeNode first = null;
	TreeNode last = null;
	TreeNode prev = null;
	boolean isDone = false;
	public void recoverTree(TreeNode root){
		recoverTreeInternal(root);
		if (!isDone && first != null && last == null){
			int temp = first.val;
        	first.val = prev.val;
        	prev.val = temp;
        	isDone= !isDone;
        }
	}
	
	private void recoverTreeInternal(TreeNode root) {
        if (root == null || isDone) return;
        
        recoverTreeInternal(root.left);
        if (first == null && (prev == null || root.val >= prev.val))
        	prev = root;
        else if (first == null){
        	first = prev; // found the first mis-placed value
        	prev = null;
        }
        
        if (first != null && root.val < first.val){
        	prev = root;
        }else if (first != null && root.val > first.val){
        	last = prev;
        }
        recoverTreeInternal(root.right);
        if (!isDone && first != null && last!=null){
        	int temp = first.val;
        	first.val = last.val;
        	last.val = temp;
        	isDone= !isDone;
        }
        return;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		TreeNode root = r.new TreeNode(1);
		root.right = r.new TreeNode(3);
		root.left = r.new TreeNode(2);
		r.recoverTree(root);
		return;
	}

}
