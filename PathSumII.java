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
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<LinkedList<Integer>> allPathList = hasPathSumList(root, sum);
		
        for (List<Integer> li : allPathList ){
        	int tempSum = 0;
        	for (Integer i : li){
        		tempSum += i;
        	}
        	if (tempSum == sum)
        		result.add(li);
        }
        return result;
    }
	
	private LinkedList<LinkedList<Integer>> hasPathSumList(TreeNode root, int sum){
		
		if (root == null)
			return new LinkedList<LinkedList<Integer>>();
		LinkedList<LinkedList<Integer>> left = hasPathSumList(root.left, sum);
		LinkedList<LinkedList<Integer>> right = hasPathSumList(root.right, sum);
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		
		for (LinkedList<Integer> i : left){
				i.addFirst(root.val);
		}
		result.addAll(left);
		for (LinkedList<Integer> i : right){
				i.addFirst(root.val);
		}
		result.addAll(right);
		if (root.left == null && root.right == null){
			LinkedList<Integer> rootNode = new LinkedList<Integer>();
			rootNode.add(root.val);
			result.addFirst(rootNode);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
