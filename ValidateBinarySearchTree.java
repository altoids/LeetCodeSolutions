import java.util.LinkedList;
import java.util.Queue;



/*
 * Validate Binary Search Tree Total Accepted: 25226 Total Submissions: 97346 My Submissions Question Solution 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}

	public boolean isValidBST(TreeNode root) {
		
		if (root == null)
			return true;
		if (isValidBST(root.right) && isValidBST(root.left)){
		int left = maxOfSubTree(root.left);
		int right = minOfSubTree(root.right);
		if (root.val <= left || root.val >= right)
			return false;
		else 
			return true;
		} else 
			return false;
		
    }
	
	private int minOfSubTree(TreeNode root){
		TreeNode cur = root;
		while (cur != null && cur.left != null){
			cur = cur.left;
		}
		if (cur == null)
			return Integer.MAX_VALUE;
		else
			return cur.val;
	}
	
	private int maxOfSubTree(TreeNode root){
		TreeNode cur = root;
		while (cur!= null && cur.right != null){
			cur = cur.right;
		}
		
		if (cur == null)
			return Integer.MIN_VALUE;
		else 
			return cur.val;
	}
	
	
	public TreeNode createTree(String[] source){
		TreeNode root = null;
		int currentIndex = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (source.length <= 0)
			return root;
		int currentLevel = (int)Math.log(source.length)*3;
		System.out.println(source[0]);
		root = source[0].equalsIgnoreCase("#")? null : new TreeNode(Integer.parseInt(source[0]));
		q.add(root);
		currentIndex ++;
		currentLevel ++;
		while(currentIndex < source.length){
			Queue<TreeNode> levelQ = new LinkedList<TreeNode>();
			while(!q.isEmpty()){
				TreeNode cur = q.poll();
				if (currentIndex < source.length){
					System.out.print(source[currentIndex]);
					for (int i = 0; i<currentLevel*3; i++) System.out.print(" ");
					cur.left = source[currentIndex].equalsIgnoreCase("#")? null : new TreeNode(Integer.parseInt(source[currentIndex]));
					currentIndex++;
					levelQ.add(cur.left);
				}
				if (currentIndex < source.length){
					System.out.print(source[currentIndex]);
					for (int i = 0; i<currentLevel*4; i++) System.out.print(" ");
					cur.right = source[currentIndex].equalsIgnoreCase("#")? null : new TreeNode(Integer.parseInt(source[currentIndex]));
					currentIndex++;
					levelQ.add(cur.right);
				}
			}
			q.addAll(levelQ);
			System.out.println("");
			currentLevel /=2;
		}
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] source = {"3","1","5","0","2","4","6","#","#","#","3"};
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		TreeNode root = v.createTree(source);
		System.out.println(v.isValidBST(root));

	}

}
