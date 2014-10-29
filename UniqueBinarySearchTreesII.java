/*
 * Unique Binary Search Trees II Total Accepted: 13962 Total Submissions: 51098 My Submissions
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */

import java.util.*;

public class UniqueBinarySearchTreesII {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; left = null; right = null; }
	}
	
	public List<TreeNode> generateTrees(int n) {
		if (n < 1){
			List<TreeNode> result = new LinkedList<TreeNode>();
			result.add(null);
			return result;
		}
		return generateTrees(1, n);
    }
	
	private List<TreeNode> generateTrees(int s, int e){
		List<TreeNode> result = new LinkedList<TreeNode>();
		if (s == e){
			result.add(new TreeNode(s));
			return result; // return empty list
		}
		
		for (int i = s; i<=e; i++){
			List<TreeNode> left = generateTrees(s, i-1);
			List<TreeNode> right = generateTrees(i+1, e);
			List<TreeNode> leadingList = null;
			List<TreeNode> trailingList = null;
			if (left.size() >= right.size()){
				leadingList = left;
				trailingList = right;
			} else {
				leadingList = right;
				trailingList = left;
			}
			
			for (TreeNode leadingNode : leadingList){
				if (trailingList.size() > 0){	
					for (TreeNode trailingNode : trailingList) {
						TreeNode curRoot = new TreeNode(i);
						if (trailingNode.val > i){
							curRoot.right = trailingNode;
							curRoot.left = leadingNode;
						} else {
							curRoot.right = leadingNode;
							curRoot.left = trailingNode;
						}
						result.add(curRoot);
					}
				} else {
					TreeNode curRoot = new TreeNode(i);
					if (leadingNode.val < i)
						curRoot.left = leadingNode;
					else
						curRoot.right = leadingNode;
					result.add(curRoot);
				}
					
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
		List<TreeNode> l = u.generateTrees(0);
		System.out.println(l.size());
	}

}
