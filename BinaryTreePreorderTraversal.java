
import java.util.*;

public class BinaryTreePreorderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> treestack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root != null)
            treestack.push(root);
       while (!treestack.empty())
       {
           TreeNode node = treestack.pop();
           result.add(node.val);
           
           if (node.right != null)
                treestack.push(node.right);
           if (node.left !=null)
                treestack.push(node.left);
           
       }
       
       return result;
}

}
