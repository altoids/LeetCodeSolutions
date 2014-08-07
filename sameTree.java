
public class sameTree {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
		 }
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null & p != q)
            return false;
        else if (q == null & q != p)
            return false;
        
        if (p.val != q.val)
            return false;
        boolean leftEqual = isSameTree(p.left, q.left);
        boolean rightEqual = isSameTree(p.right, q.right);
        return leftEqual && rightEqual;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
