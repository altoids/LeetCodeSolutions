/*
 * Minimum Depth of Binary Tree Total Accepted: 22465 Total Submissions: 75762 My Submissions
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

public class MinimumDepthofBinaryTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int ld = minDepth(root.left);
		int rd = minDepth(root.right);
		int result = 0;
		if (ld != 0 && rd != 0)
			result = Math.min(rd, ld);
		else if (rd == 0)
			result = ld;
		else 
			result = rd;
		return result + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
