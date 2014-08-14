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
	
	HashMap<String, Integer> hs = new HashMap<String, Integer>();
	private int minmumTotalInternal(List<List<Integer>> triangle, int rootLayer, int rootIndex){
		//System.out.println("Layer = " + rootLayer + ", RootIndex = " + rootIndex);
		if (triangle == null || triangle.size() <= rootLayer)
			return 0;
		String key = rootLayer + "," + rootIndex;
		if (hs.containsKey(key)){
			return hs.get(key);
		}
		int root = triangle.get(rootLayer).get(rootIndex);
		if (triangle.size() <= rootLayer+1)
			return root;
		int leftSubMin = minmumTotalInternal(triangle, rootLayer + 1, rootIndex);
		int rightSubMin = minmumTotalInternal(triangle, rootLayer + 1, rootIndex +1);
		int result = root + Math.min(leftSubMin, rightSubMin);
		hs.put(key, result);
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		Scanner sIn = new Scanner(System.in);
		String oneline = sIn.nextLine();
		while (!oneline.isEmpty()){
			if (oneline.charAt(0) == '['){
				// start of a new layer
				
				int firstright = oneline.indexOf("]");
				String oneLayer = oneline.substring(1, firstright);
				System.out.println(oneLayer);
				if (firstright  != oneline.length() - 1)
					oneline = oneline.substring(firstright + 2);
				else
					oneline = "";
				String[] numberStringInOneLayer = oneLayer.split(",");
				ArrayList<Integer> numberInOneLayer = new ArrayList<Integer>(numberStringInOneLayer.length);
				for (int i = 0; i< numberStringInOneLayer.length; i++){
					numberInOneLayer.add(i, Integer.parseInt(numberStringInOneLayer[i]));
				}
				triangle.add(numberInOneLayer);
			}
		}
		
		Triangle t = new Triangle();
		System.out.println("total Layer is: " + triangle.size());
		System.out.println("start processing...");
		long starttime = System.currentTimeMillis();
		System.out.println(t.minimumTotal(triangle));
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
		sIn.close();

	}

}
