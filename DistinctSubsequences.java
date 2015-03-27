import java.util.*;

public class DistinctSubsequences {

	public int numDistinct(String S, String T) {
        if (T.length() == 0)
        	return 0;
        int[] count = new int[T.length()];
        for (int indexS = 0; indexS < S.length(); indexS ++) {
        	char curS = S.charAt(indexS);
        	for (int indexT = T.length() -1; indexT >=0; indexT--) {
        		char curT = T.charAt(indexT);
        		if (curT == curS) {
        			if (indexT == 0)
        				count[0]++;
        			else
        				count[indexT] += count[indexT-1];
        		}
        	}
        }
        return count[T.length()-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences ds = new DistinctSubsequences();
		int count = ds.numDistinct("ddd", "dd");
		System.out.println(count);

	}

}
