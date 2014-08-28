/*
 * Unique Binary Search Trees Total Accepted: 21895 Total Submissions: 60090 My Submissions
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
import java.util.*;

public class UniqueBinarySearchTree {
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n== 2)
            return 2;
        int result = 0;
        if (hm.containsKey(n))
            return hm.get(n);
        for (int i = 1; i<= n; i++)
            result += numTrees(n-i)*numTrees(i-1);
        hm.put(n,result);
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
