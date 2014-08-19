/*There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 */

import java.util.*;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int A[], int B[]) {
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int alen = sIn.nextInt();
		int[] a = new int[alen];
		for (int i = 0; i< alen; i++){
			a[i] = sIn.nextInt();
		}
		
		int blen = sIn.nextInt();
		int[] b = new int[blen];
		for (int i = 0; i< blen; i++){
			b[i] = sIn.nextInt();
		}

	}

}
