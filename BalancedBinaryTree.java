/*
 * Balanced Binary Tree Total Accepted: 23756 Total Submissions: 72573 My Submissions
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	
	public boolean isBalanced(TreeNode root) {
		if (checkDepth(root) >=0) return true;
		return false;
    }
	
	// return -1 if the subtree is not balanced, otherwise return the max depth of the subtree
	private int checkDepth (TreeNode root){
		if (root == null) return 0;
		
		int left = checkDepth(root.left);
		int right = checkDepth(root.right);
		
		if (left <0 || right <0) return -1; // one of the subtree is unbalanced, no point of checking further
		if (Math.abs(Math.abs(left)-Math.abs(right)) >1 ) return -1; // become unbalanced at this point, return -1
		return Math.max(Math.abs(left), Math.abs(right)) + 1;
	}
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		TreeNode root = bbt.new TreeNode(1);
		root.right = bbt.new TreeNode(2);
		root.right.right = bbt.new TreeNode(3);
		System.out.println(bbt.isBalanced(root));

	}

}
