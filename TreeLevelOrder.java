/*
 * Binary Tree Level Order Traversal Total Accepted: 19208 Total Submissions: 62389 My Submissions
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
import java.util.*;
public class TreeLevelOrder {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
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
                    result.add(levelList);
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
        result.add(levelList);
        return result;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
