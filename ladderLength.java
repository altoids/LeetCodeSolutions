import java.util.*;


public class ladderLength {
	HashSet<String> hs = new HashSet<String>();
	public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<String> ll = new LinkedList<String>();
        LinkedList<Integer> lli = new LinkedList<Integer>();
        int minSteps = Integer.MAX_VALUE;
        int level = 0;
        ll.add(start);
        lli.add(0);
        while (!ll.isEmpty()){
        	String oneWord = ll.removeFirst();
        	level = lli.removeFirst() + 1;
        	if (oneWord.equals(end)){
        		if (minSteps > (level -1))
        			minSteps = level;
        		continue;
        	}
        	for (int i = 0; i< oneWord.length(); i++){
        		LinkedList<String> allWords = getAllPossibleWordsByChangeithLetter(oneWord, end, dict, i);
        		int returnSize = allWords.size();
        		for (int j = 0; j<returnSize; j++){
        			lli.add(level);
        			ll.add(allWords.removeFirst());
        		}
        		
        	}
        }
        if (minSteps == Integer.MAX_VALUE)
        	return 0;
        else
        	return minSteps;
    }
	
	private LinkedList<String> getAllPossibleWordsByChangeithLetter(String a, String end, Set<String> dict, int i){
		hs.add(a);
		String left = a.substring(0, i);
		String right = a.substring(i+1, a.length());
		LinkedList<String> ll = new LinkedList<String>();
		for (int j = 0; j<26; j++){
			String temp = left + (char)('a'+j) + right;
			if (dict.contains(temp) && !hs.contains(temp) || temp.equals(end)){
				ll.add(temp);
				hs.add(temp);
			}
		}
		return ll;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ladderLength llen = new ladderLength();
		String start = "a";
		String end = "c";
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		//dict.add("lot");
		//dict.add("log");
		System.out.println(llen.ladderLength(start, end, dict));

	}

}
