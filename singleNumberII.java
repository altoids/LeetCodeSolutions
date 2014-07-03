
import java.util.*;

public class singleNumberII {
	public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i<A.length;i++)
        {
            if (map.containsKey(A[i]))
            {
                int temp = map.remove(A[i]);
                if (temp <2)
                {
                    temp++;
                    map.put(A[i],temp);
                }
            }
            else
            {
                map.put(A[i],1);
            
            }
        }
        //map must only contains one key,value pair
        Set<Integer> keys = map.keySet();
        Iterator iter = keys.iterator();
        return (Integer)iter.next();
        
    }
	/*
	 * To solve this problem using only constant space, you have to rethink how the numbers are being represented in computers -- using bits.

If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 due to the constraint of this problem where each number must appear either three times or once. This will be the ith bit of that "single number".

A straightforward implementation is to use an array of size 32 to keep track of the total count of ith bit.
	 */
	public int singleNumberII(int[] A){
		int[] count = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        for (int j = 0; j < A.length; j++) {
	            if (((A[j] >> i) & 1) >0) {
	                count[i]++;
	            }
	        }
	        result |= ((count[i] % 3) << i);
	    }
	    return result;
	}
	/*
	 * We can improve this based on the previous solution using three bitmask variables:

    ones as a bitmask to represent the ith bit had appeared once.
    twos as a bitmask to represent the ith bit had appeared twice.
    threes as a bitmask to represent the ith bit had appeared three times.

When the ith bit had appeared for the third time, clear the ith bit of both ones and twos to 0. The final answer will be the value of ones.
	 */
	public int singleNumberIII(int[] A){
		int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	
	
}
