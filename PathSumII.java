import java.util.LinkedList;
import java.util.List;

import PathSum.TreeNode;

/*
 * Path Sum II Total Accepted: 18243 Total Submissions: 67519 My Submissions
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class PathSumII {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
    }
	
	private List<List<Integer>> hasPathSumList(TreeNode root, int sum){
		
		if (root == null)
			return new LinkedList<List<Integer>>();
		List<List<Integer>> left = hasPathSumList(root.left, sum);
		List<List<Integer>> right = hasPathSumList(root.right, sum);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		for (List<Integer> i : left){
				i.add(root.val);
		}
		result.addAll(left);
		for (List<Integer> i : right){
				i.add(root.val);
		}
		result.addAll(right);
		if (root.left == null && root.right == null){
			List<Integer> rootNode = new LinkedList<Integer>();
			rootNode.add(root.val);
			result.add(rootNode);
		}
		    
		return result;
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
