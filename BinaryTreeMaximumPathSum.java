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
	      
        maxPathSumInternal(root);
        return this.max;
    }
	private int maxPathSumInternal(TreeNode root){
		if (root == null)
        	return Integer.MIN_VALUE;
        int left = maxPathSumInternal(root.left);
        int right = maxPathSumInternal(root.right);
        return setMax(root, left, right);
	}
	
	private int setMax(TreeNode root, int left, int right){
		int result = Integer.MIN_VALUE;
		int sumOf3Parts = (root.val == Integer.MIN_VALUE || left == Integer.MIN_VALUE || right == Integer.MIN_VALUE)? Integer.MIN_VALUE:root.val + left + right;
        int sumOfLeftPath = (root.val == Integer.MIN_VALUE || left == Integer.MIN_VALUE)? Integer.MIN_VALUE:root.val + left;
        int sumOfRightPath = (root.val == Integer.MIN_VALUE || right == Integer.MIN_VALUE)? Integer.MIN_VALUE:root.val + right;
        
        int maxOfBranches = Math.max(Math.max(root.val, sumOf3Parts), Math.max(sumOfLeftPath, sumOfRightPath));
        int maxOfLeaves = Math.max(left, right);
        
        if (Math.max(maxOfBranches, maxOfLeaves) > this.max)
        	this.max = Math.max(maxOfBranches, maxOfLeaves);
        if (maxOfLeaves <= maxOfBranches)
        	result = maxOfBranches;
        return result;
	}
	//end of main code
	//below are test code
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum m = new BinaryTreeMaximumPathSum();
		//build a binary tree from an array
		TreeNode root = m.buildTreeFromArray(m);
		
		System.out.println(m.maxPathSum(root));
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
