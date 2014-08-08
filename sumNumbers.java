
public class sumNumbers {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	
	public int sumNumbers(TreeNode root) {
       	return sumNumberInternal(root, 0);
    }
	
	private int sumNumberInternal(TreeNode root, int parentNum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return parentNum * 10 + root.val;
		
		int left = sumNumberInternal(root.left, parentNum * 10 + root.val);
		int right = sumNumberInternal(root.right, parentNum * 10 + root.val);
		
		return left + right; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sumNumbers s = new sumNumbers();
		TreeNode root = s.new TreeNode(1);
		//root.left = s.new TreeNode(0);
		System.out.println(s.sumNumbers(root));

	}

}
