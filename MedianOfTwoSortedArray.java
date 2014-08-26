/*There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
 */

import java.util.*;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
        if ((m + n) % 2 == 0)
        	return (getMedian(A, B, (m+n)/2) + getMedian(A, B, (m+n)/2+1))/2;
        else
        	return getMedian(A,B, (m+n)/2 + 1);
    }
	
	private double getMedian(int a[], int b[], int k){
		int m = a.length;
		int n = b.length;
		
		if (m <= 0) return b[k-1];
		if (n <= 0) return a[k-1];
		if (k <= 1) return Math.min(a[0], b[0]);
		
		if (m/2 + n/2 + 1 >= k){
			if (a[m/2] >= b[n/2]) // a 2 should be removed
				return getMedian(Arrays.copyOfRange(a, 0, m/2), b, k);
			else
				return getMedian(a, Arrays.copyOfRange(b, 0, n/2), k );
		}else{
			if (a[m/2] >= b[n/2]) // b 1 should be removed
				return getMedian(a, Arrays.copyOfRange(b, n/2+1, n), k- n/2-1);
			else
				return getMedian(Arrays.copyOfRange(a,m/2+1, m), b, k- m/2-1);
		}
		
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
		
		MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
		System.out.println(m.findMedianSortedArrays(a, b));

	}

}
