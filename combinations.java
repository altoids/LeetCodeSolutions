/*
 * Combinations Total Accepted: 18192 Total Submissions: 60037 My Submissions
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
import java.util.*;
public class combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (k == 0 || n == 0){
            result = new LinkedList<List<Integer>>();
            return result;
        }
        
        for (int i = n; i>=k; i--){
            List<List<Integer>> midReturn = null;
            if(k == 1){
            	List<Integer> ltemp = new LinkedList<Integer>();
	            ltemp.add(i);
	            midReturn = new LinkedList<List<Integer>>();
	            midReturn.add(ltemp);
            }else{
            	midReturn = combine(i-1,k-1);
	            for (List<Integer> li : midReturn)
	            	li.add(i);
            }
            result.addAll(midReturn);
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		combinations c = new combinations();
		System.out.println(c.combine(4, 2));
	}

}
