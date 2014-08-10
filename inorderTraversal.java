import java.util.*;

public class inorderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public LinkedList<Integer> inorderTraversal(TreeNode root){
		 LinkedList<Integer> ll = new LinkedList<Integer>();
	     Stack<TreeNode> st = new Stack<TreeNode>();
	     if (root == null)
	         return ll;
	     if (root.right != null)
	    	 st.push(root.right);
	     TreeNode left = root.left;
	     root.left = null;
	     root.right = null;
	     st.push(root);
	     if (left != null)
	    	 st.push(left);
	     while(!st.isEmpty()){
	    	 TreeNode cur = st.pop();
	    	 if (cur.left == null && cur.right == null){
	    		 //visit cur
	    		 ll.add(cur.val);
	    		 continue;
	    	 }
	    	 if (cur.right != null)
	    		 st.push(cur.right);
	    	 left = cur.left;
	    	 cur.left = null;
	    	 cur.right = null;
	    	 st.push(cur);
	    	 if (left != null)
	    		 st.push(left);
	     }
	     
	     return ll;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
