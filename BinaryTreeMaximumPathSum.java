/*
 * Binary Tree Maximum Path Sum Total Accepted: 17353 Total Submissions: 86764 My Submissions
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
import java.util.*;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public int maxPathSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        
        if (root == null)
        	return Integer.MIN_VALUE;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        
        int sumOf3Parts = root.val + left + right;
        int sumOfLeftPath = root.val + left;
        int sumOfRightPath = root.val + right;
        
        return Math.max(Math.max(root.val, sumOf3Parts), Math.max(sumOfLeftPath, sumOfRightPath));
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
