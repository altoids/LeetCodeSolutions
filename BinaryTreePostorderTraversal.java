import java.util.*;

public class BinaryTreePostorderTraversal{
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	    public List<Integer> postorderTraversal(TreeNode root) {
	        
	        Stack<TreeNode> treestack = new Stack<TreeNode>();
	        Stack<Integer> valstack = new Stack<Integer>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if (root != null)
	            treestack.push(root);
	       while (!treestack.empty())
	       {
	           TreeNode node = treestack.pop();
	           valstack.push(node.val);
	           
	           if (node.left != null)
	                treestack.push(node.left);
	           if (node.right !=null)
	                treestack.push(node.right);
	           
	       }
	       while (!valstack.empty())
	       {
	           result.add(valstack.pop());
	       }
	       return result;
	    }
}