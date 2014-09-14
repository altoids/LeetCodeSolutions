/*
 * Binary Tree Zigzag Level Order Traversal Total Accepted: 15596 Total Submissions: 58369 My Submissions
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		boolean isLeftToRight = true;
		if (root != null)
			s.push(root);
		
		while (!s.isEmpty()){
			List<Integer> line = new LinkedList<Integer>();
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			while(!s.isEmpty()){
				TreeNode cur = s.pop();
				line.add(cur.val);
				if (isLeftToRight){
				    if (cur.left != null)
					    q.add(cur.left);
					if (cur.right != null)
					    q.add(cur.right);
				}else{
				    if (cur.right != null)
					    q.add(cur.right);
					if (cur.left != null)
					    q.add(cur.left);
				}
			}
			if (!line.isEmpty())
				result.add(line);
			while(!q.isEmpty())
				s.push(q.remove());
			isLeftToRight = !isLeftToRight;
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
