import java.util.Scanner;

/*
 * Jump Game II Total Accepted: 14777 Total Submissions: 60214 My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
	public int jump(int[] A) {
        if (A == null || A.length <=1)
            return 0;
        int index = 0;
        int pace = 0;
        int steps = 0;
        while (index <= pace){
        	// note, maxpace is always == current index + value at this index.
        	int maxpace = A[index] + index;
        	int tmpIndex = index;
        	for (tmpIndex = index; tmpIndex < A.length && tmpIndex <= pace; tmpIndex++){// this loop is to find what's max pace we can take
                if (maxpace < tmpIndex + A[tmpIndex])
                	maxpace = tmpIndex + A[tmpIndex];
            }
        	
            if (maxpace > pace){
            	pace = maxpace;
            	steps++; // value changed in pace means we took a step
            }
            index = tmpIndex;
            if (pace >= A.length-1)
                return steps;
        }
        return -1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sIn = new Scanner(System.in);
		String oneline;
		String[] ns;
		int[] n;
		while(sIn.hasNextLine()){
			oneline = sIn.nextLine();
			ns = oneline.split(",");
			n = new int[ns.length];
			for (int i = 0; i < ns.length; i++){
				n[i] = Integer.parseInt(ns[i]);
			}
			JumpGameII jg = new JumpGameII();
			System.out.println(oneline);
			System.out.println(jg.jump(n));
			System.out.println("--------------------");
			
		}
	}

}
