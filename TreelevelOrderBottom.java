/*
 * Binary Tree Level Order Traversal II Total Accepted: 15774 Total Submissions: 50472 My Submissions
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */


import java.util.*;
public class TreelevelOrderBottom {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<Integer> qLevel = new LinkedList<Integer>();
        q.add(root);
        qLevel.add(1);
        int level = 0;
        ArrayList<Integer> levelList = null;
        while (q.size() >0){
            TreeNode cur = q.removeFirst();
            Integer curLevel = qLevel.removeFirst();
            if (curLevel > level){
                if (levelList != null)
                    result.addFirst(levelList);
                levelList = new ArrayList<Integer>();
                level = curLevel;
            }
            if (cur.left != null){
                q.add(cur.left);
                qLevel.add(curLevel + 1);
            }
            if (cur.right != null){
                q.add(cur.right);
                qLevel.add(curLevel + 1);
            }
            levelList.add(cur.val);
        }
        result.addFirst(levelList);
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
