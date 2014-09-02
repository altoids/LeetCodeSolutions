/*
 * Convert Sorted Array to Binary Search Tree Total Accepted: 19009 Total Submissions: 58267 My Submissions
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
passed oj
 */

import java.util.*;
public class ConvertSortedArraytoBinarySearchTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		      
		  }
	public TreeNode sortedArrayToBST(int[] num) {
		//sorted array, pick from middle for root.
		if (num == null || num.length == 0)
			return null;
		int rootindex = num.length/2;
		TreeNode root = new TreeNode(num[rootindex]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, rootindex));
		root.right = sortedArrayToBST(Arrays.copyOfRange(num, rootindex +1, num.length));
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(sIn.hasNext()){
			al.add(sIn.nextInt());
		}
		int[] num = new int[al.size()];
		for (int i = 0; i< al.size(); i++){
			num[i] = al.get(i);
		}
		Arrays.sort(num);
		/*for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
		System.out.println("");*/
		ConvertSortedArraytoBinarySearchTree c = new ConvertSortedArraytoBinarySearchTree();
		printTree(c.sortedArrayToBST(num));
		
	}
	private static void printTree(TreeNode root){
		//inordertravel, it should print a sorted number list
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.val + " ");
		printTree(root.right);
	}

}
