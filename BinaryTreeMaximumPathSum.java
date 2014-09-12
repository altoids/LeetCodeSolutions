/*
 * Binary Tree Maximum Path Sum Total Accepted: 17353 Total Submissions: 86764 My Submissions
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
import java.util.*;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	// main code start
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		//traverse(root);
        maxPathSumInternal(root);
        return this.max;
    }
	
	private int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        if (left+root.val+right>max) max=left+root.val+right;
        if (left<right) left=right;
        int mmtmp=left+root.val;
        if (left+root.val<root.val) mmtmp=root.val;
        if (mmtmp<0) return 0; else return mmtmp;
    }
	
	private int maxPathSumInternal(TreeNode root){
		if (root == null) return 0;
        int left = maxPathSumInternal(root.left);
        int right = maxPathSumInternal(root.right);
        return setMax(root, left, right);
	}
	
	private int setMax(TreeNode root, int left, int right){
		int sumOf3Parts = root.val + left + right;
        int sumOfLeftPath = root.val + left;
        int sumOfRightPath = root.val + right;
        
        int maxOfBranches = Math.max(root.val, Math.max(sumOfLeftPath, sumOfRightPath));
        
        if (sumOf3Parts > this.max)
        	this.max = sumOf3Parts;
    	
        return maxOfBranches<0?0:maxOfBranches;
	}
	//end of main code
	//below are test code
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum m = new BinaryTreeMaximumPathSum();
		//build a binary tree from an array
		TreeNode root = m.buildTreeFromTestCase();
		
		System.out.println(m.maxPathSum(root));
	}
	
	private TreeNode buildTreeFromTestCase(){
		//5,4,8,11,#,13,4,7,2,#,#,#,1
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		//root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		
		return root;
	}
	
	private TreeNode buildTreeFromArray(BinaryTreeMaximumPathSum m){
		/*Scanner sIn = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(sIn.hasNext()){
			al.add(sIn.nextInt());
		}
		int[] num = new int[al.size()];
		for (int i = 0; i< al.size(); i++){
			num[i] = al.get(i);
		}*/
		//Arrays.sort(num);
		/*for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
		System.out.println("");*/
		Random rm = new Random();
		int[] num = new int[Math.abs(rm.nextInt(999999))];
		System.out.println("Size:" + num.length);
		for (int i = 0; i< num.length ; i++){
			num[i] = rm.nextInt(999)*(rm.nextBoolean()?-1:1);
		}
		return m.sortedArrayToBST(num);
	}
	private TreeNode sortedArrayToBST(int[] num) {
		//sorted array, pick from middle for root.
		if (num == null || num.length == 0)
			return null;
		int rootindex = num.length/2;
		TreeNode root = new TreeNode(num[rootindex]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, rootindex));
		root.right = sortedArrayToBST(Arrays.copyOfRange(num, rootindex +1, num.length));
        return root;
    }

}
