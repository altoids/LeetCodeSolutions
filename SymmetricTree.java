/*
 * Symmetric Tree Total Accepted: 24341 Total Submissions: 75343 My Submissions
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
import java.util.*;
public class SymmetricTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root != null)
			q.add(root);
		while (!q.isEmpty()){
			Queue<TreeNode> childrenQ = new LinkedList<TreeNode>();
			ArrayList<Integer> line = new ArrayList<Integer>();
			while(!q.isEmpty()){
				TreeNode cur = q.remove();
				if (cur.left != null){
					childrenQ.add(cur.left);
					line.add(cur.left.val);
				}else
					line.add(null);
				
				if (cur.right != null){
					childrenQ.add(cur.right);
					line.add(cur.right.val);
				}else
					line.add(null);
				
			}
			if (!isMirrored(line))
				return false;
			q.addAll(childrenQ);
		}
		return true;
    }
	
	private boolean isMirrored(ArrayList<Integer> line){
	    if (line.size() % 2 != 0)
	        return false;
		for (int i = 0; i<line.size()/2; i++){
			if (line.get(i) != line.get(line.size()-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
