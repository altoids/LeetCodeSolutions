import java.util.*;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		return minmumTotalInternal(triangle, 0, 0);
    }
	
	private int minmumTotalInternal(List<List<Integer>> triangle, int rootLayer, int rootIndex){
		if (triangle == null || triangle.size() <= rootLayer)
			return 0;
		int root = triangle.get(rootLayer).get(rootIndex);
		if (triangle.size() <= rootLayer+1)
			return root;
		int leftSubMin = minmumTotalInternal(triangle, rootLayer + 1, rootIndex);
		int rightSubMin = minmumTotalInternal(triangle, rootLayer + 1, rootIndex +1);
		return root + Math.min(leftSubMin, rightSubMin);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		int[] a = {2, 3, 4, 6, 5, 7, 4, 1, 8, 3};
		int height = 4;
		int count = 0;
		for (int i = 0; i<height; i++){
			List<Integer> oneline = new ArrayList<Integer>();
			for (int j = 0; j<i+1;j++){
				oneline.add(j,a[count++]);
			}
			triangle.add(oneline);
		}
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));

	}

}
