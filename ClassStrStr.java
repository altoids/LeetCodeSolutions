
import java.util.*;

public class ClassStrStr {
	
	private int R = 0;
    private int M = 0;
    private int[][] dfa = null;
    private Map<Character, Integer> hm = new HashMap<Character, Integer>(); 
    
    private void KMP(String pat) {
        M = pat.length();
        int index = 0;
        for (char c : pat.toCharArray()) {
        	if (!hm.containsKey(c))
        		hm.put(c, index++);
        }
        R = hm.size();
        dfa = new int[R][M];
        dfa[hm.get(pat.charAt(0))][0] = 1;
        for (int X = 0, j = 1; j<M; j++) {
        	for (char c : hm.keySet())
        		dfa[hm.get(c)][j] = dfa[hm.get(c)][X];
        	dfa[hm.get(pat.charAt(j))][j] = j+1;
        	X = dfa[hm.get(pat.charAt(j))][X];
        }
        
    }
    public int strStr(String haystack, String needle) {
    	if (haystack.length() <=0 || needle.length() <=0)
            return -1;
        KMP(needle); // build DFA
        int i, j;
        for (i = 0, j= 0; i<haystack.length() && j < M; i++) {
        	char c = haystack.charAt(i);
        	if (hm.containsKey(c))
        		j = dfa[hm.get(haystack.charAt(i))][j];
        	else
        		j = 0;
        }
        if (j == M) return i - M;
        else
        	return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassStrStr css = new ClassStrStr();
		System.out.println(css.strStr("aaa", "aa"));
		
	}

}
