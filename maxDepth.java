
public class maxDepth {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		 }
	
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0; // null is 0 level
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if (leftDepth >= rightDepth)
			return leftDepth + 1;
		else
			return rightDepth + 1;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
