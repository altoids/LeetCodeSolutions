import java.util.Arrays;

/*
 * Construct Binary Tree from Inorder and Postorder Traversal Total Accepted: 14572 Total Submissions: 54965 My Submissions
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0) return null;
		
		int pLen = postorder.length;
		TreeNode root = new TreeNode(postorder[pLen-1]);
		int rootIndex = 0;
		while (inorder[rootIndex] != postorder[pLen-1]) rootIndex++;
		// split the inorder array by rootindex
		int[] inorderlsub = Arrays.copyOfRange(inorder, 0, rootIndex);
		int[] inorderrsub = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
		int[] postorderlsub = Arrays.copyOfRange(postorder, 0, inorderlsub.length);
		int[] postorderrsub = Arrays.copyOfRange(postorder, inorderlsub.length, pLen-1);

		root.right = buildTree(inorderrsub,postorderrsub);
		root.left = buildTree(inorderlsub, postorderlsub);
		
		return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromInorderandPostorderTraversal c = new ConstructBinaryTreefromInorderandPostorderTraversal();
		int[] inorder = {2,1,3};
		int[] postorder = {2,3,1};
		
		c.buildTree(inorder, postorder);
		

	}

}
