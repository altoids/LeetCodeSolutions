import java.util.LinkedList;
import java.util.List;

/*
 * Path Sum Total Accepted: 20105 Total Submissions: 65773 My Submissions
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> results = hasPathSumList(root,sum);
        for (Integer i : results)
        	if (i == sum)
        		return true;
        return false;
    }
	
	private List<Integer> hasPathSumList(TreeNode root, int sum){
		
		if (root == null)
			return new LinkedList<Integer>();
		List<Integer> left = hasPathSumList(root.left, sum);
		List<Integer> right = hasPathSumList(root.right, sum);
		List<Integer> result = new LinkedList<Integer>();
		for (Integer i : left){
				result.add(i+root.val);
		}
		for (Integer i : right){
				result.add(i+root.val);
		}
		if (root.left == null && root.right == null)
		    result.add(root.val);
		return result;
		
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
