import java.util.*;

public class SubsetsII {
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        int len = num.length;
        long power = (long)Math.pow(2, len);
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        for (long i = 1; i<= power; i++) {
        	List<Integer> curList = new ArrayList<Integer>();
        	long tempi = i;
        	int j = 0;
        	while (tempi >= 1 && j < len) {
	        	if (tempi % 2 == 1) {
	        		curList.add(num[j]);
	        	}
	        	j ++;
	        	tempi >>= 1;
        	}
        	
        	if (!result.contains(curList)) {
        		result.add(curList);
        	}
        }
        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
        for (List<Integer> li : result)
        	listResult.add(li);
		return listResult;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetsII ss = new SubsetsII();
		int[] S = {1, 2, 2};
		List<List<Integer>> lli = ss.subsetsWithDup(S);
		for (List<Integer> li : lli) {
			System.out.print("Size=" + li.size() + ":");
			for (Integer i : li) {
				System.out.print(i + ",");
			}
			System.out.println("");
			
		}

	}

}
