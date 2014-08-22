/*
 * Jump Game Total Accepted: 17188 Total Submissions: 63317 My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */

import java.util.*;

public class JumpGame {
	
	public boolean canJump(int[] A) {
        if (A==null || A.length==0) return true;
        int step = 0,index=0;
        while (index<=step){
            step=Math.max(step,index+A[index++]);
            if (step>=A.length-1)
                return true;
        }
        return false;
    }
	
	/*public boolean canJump(int[] A) {
        return canJumpSub(A, 0);
    }*/

    /*
	private boolean canJumpSub(int[] A, int start){
		int[] B = new int[A.length];
    	for (int i = 0; i< A.length; i++){
    		// add position and value
    		B[i] = i + A[i];
    	}
    	Arrays.sort(B);
    	if (A.length > 1 && B[A.length-2] < A.length-1){
    		//System.out.println("quick exit");
    		return false;
    	}
    	//System.out.println(B.clone()[A.length -1]);
    	Stack<Integer> s = new Stack<Integer>();
    	HashSet<Integer> set = new HashSet<Integer>();
    	s.push(start);
    	set.add(start);
        while (!s.isEmpty()){
        	int curStart = s.pop();
	    	if (curStart == A.length-1 || (curStart + A[curStart]) >= A.length-1)
	        	return true;
	        if (A[curStart] == 0)
	        	continue;
	        for (int i = 1; (curStart+i< A.length) && i <= A[curStart]  ; i++){
	        	if (!set.contains(curStart+i)){
	        		s.push(curStart + i);
	        		set.add(curStart + i);
	        	}
	        }
        }
        return false;
    }
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		String oneline = sIn.nextLine();
		String[] ns = oneline.split(",");
		int[] n = new int[ns.length];
		for (int i = 0; i < ns.length; i++){
			n[i] = Integer.parseInt(ns[i]);
		}
		JumpGame jg = new JumpGame();
		System.out.println(n.length);
		System.out.println(jg.canJump(n));

	}

}
