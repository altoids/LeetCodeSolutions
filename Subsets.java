import java.util.*;


public class Subsets {
	/*
	 * leverage the binary representation 
	 */
	public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int len = S.length;
        long power = (long)Math.pow(2, len);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (long i = 1; i<= power; i++) {
        	List<Integer> curList = new ArrayList<Integer>();
        	long tempi = i;
        	int j = 0;
        	while (tempi >= 1 && j < len) {
	        	if (tempi % 2 == 1) {
	        		curList.add(S[j]);
	        	}
	        	j ++;
	        	tempi >>= 1;
        	}
        	result.add(curList);
        }
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets ss = new Subsets();
		int[] S = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		List<List<Integer>> lli = ss.subsets(S);
		for (List<Integer> li : lli) {
			System.out.print("Size=" + li.size() + ":");
			for (Integer i : li) {
				System.out.print(i + ",");
			}
			System.out.println("");
			
		}

	}

}
