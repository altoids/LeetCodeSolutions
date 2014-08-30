/*
 * Sort Colors Total Accepted: 21272 Total Submissions: 66466 My Submissions
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {

	public void sortColors(int[] A) {
        int last0 = -1;
        int first2 = A.length;
        boolean changed = true;
        for (int i = 0; i<=Math.min(first2, A.length-1); i++){
        	while (changed){
        		changed = false;
	        	if (A[i] == 0){
	        		if (i > last0){
	        			A[i] = A[++last0];
	        			A[last0] = 0;
	        			changed = true;
	        		}
	        	}
	        	if (A[i] == 2){
	        		if (i <first2){
	        			A[i] = A[--first2];
	        			A[first2] = 2;
	        			changed = true;
	        		}
	        	}
        	}
        	changed = true;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColors s = new SortColors();
		int[] A = {2};
		s.sortColors(A);
		for (int i : A)
			System.out.println(i);

	}

}
