import java.util.*;

public class findLadders {
	/*
	private class wordbox implements Comparable<wordbox>{
		String word;
		wordbox ancestor;
		public int distance;
		public short level;
		public wordbox(String w, String end, wordbox a, short level) {
			word = w;
			ancestor = a;
			this.level = level;
			this.distance = distanceToEnd(end);
		}
		
		private int distanceToEnd(String that){
			int count = 1;
			for (int i = 0; i< this.word.length(); i++){
				if (this.word.charAt(i) != that.charAt(i))
					count += count << (i + 1) + i;
			}
			return count;
		}
		
		public int compareTo(wordbox that) {
			// TODO Auto-generated method stub
			return distance - that.distance;
		}
	}
	PriorityQueue<wordbox> llForward = new PriorityQueue<wordbox>();
	PriorityQueue<wordbox> llBackward = new PriorityQueue<wordbox>();
    HashMap<String, HashSet<String>> hmWordGraph = new HashMap<String, HashSet<String>>(); 
    HashSet<String> hsForwardNotComingBack = new HashSet<String>();
    HashSet<String> hsBackwardNotComingBack = new HashSet<String>();
    
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        //build graph of word transition. every outgoing link is to another word that is one letter different.
		// hashmap  key is every word in dict.
		// value is an arraylist that contains all words that is one letter different from key
		dict.add(start);
		dict.add(end);
		for (String s : dict){
			//assuming there's no dupes in the dict
			//first time see the word in the key, new the arraylist
			HashSet<String> arl = new HashSet<String>();
			for (int i = 0; i < s.length(); i++)
				arl.addAll(getAllPossibleWordsByChangeithLetter(s, dict, i));
			hmWordGraph.put(s, arl);
		}
		
		LinkedList<List<String>> resultsForward = new LinkedList<List<String>>();
        LinkedList<List<String>> resultsBackward = new LinkedList<List<String>>();    
        int[] minStepsForward = {Integer.MAX_VALUE};
        int[] minStepsBackward = {Integer.MAX_VALUE};
        short levelForward = 0;
        short levelBackward = 0;
        llForward.add(new wordbox(start,end, null, levelForward));
        llBackward.add(new wordbox(end,start, null, levelBackward));
        boolean isForward = true;
        //int min = Integer.MAX_VALUE;
        while (!llForward.isEmpty() && !llBackward.isEmpty()){
        	
        	if (resultsForward.size() > resultsBackward.size()){
        		isForward = true;
        	}
        	else if (resultsForward.size() < resultsBackward.size()){
        		isForward = false;
        	}
        	else {
	        	//isForward ^=true;
        		isForward = true;
        	}
        	
        	if (isForward)
        		resultsForward = processOneStep(isForward, resultsForward, minStepsForward, start, end);
        	else
        		resultsBackward = processOneStep(isForward, resultsBackward, minStepsBackward, end, start);
        }
        if (resultsForward.size() >= resultsBackward.size())
        	return resultsForward;
        else
        	return resultsBackward;
    }
	
	private HashSet<String> getAllPossibleWordsByChangeithLetter(String word, Set<String> dict, int i){
		String a = word;
		String left = a.substring(0, i);
		String right = a.substring(i+1, a.length());
		HashSet<String> ll = new HashSet<String>();
		for (int j = 0; j<26; j++){
			String temp = left + (char)('a'+j) + right;
			if (dict.contains(temp) && !temp.equals(word)){
				ll.add(temp);
			}
		}
		return ll;
	}
    	
	private LinkedList<List<String>> processOneStep(boolean isForward, LinkedList<List<String>> results , int[] minSteps, String start, String end){
		PriorityQueue<wordbox> ll = isForward?llForward:llBackward;
		HashSet<String> hsNotComingBack = isForward?hsForwardNotComingBack:hsBackwardNotComingBack;
		wordbox oneWord = ll.remove();
		short level = oneWord.level;
		level ++;
    	if (level > minSteps[0] || level >  hmWordGraph.size())
    		return results;
    	
    	if (oneWord.word.equals(end)){
    		if (minSteps[0] >= level){
    			if (minSteps[0] > level){
        			minSteps[0] = level;
        			results = new LinkedList<List<String>>(); //restart the list, we found less step
    			}
    			LinkedList<String> oneAnswer = new LinkedList<String>();
    			wordbox tempWordBox = oneWord;
    			while (!tempWordBox.word.equals(start)){
    				if (isForward){
    					oneAnswer.addFirst(tempWordBox.word);
    				}
    				else{
    					oneAnswer.addLast(tempWordBox.word);
    				}
    				tempWordBox = tempWordBox.ancestor;
    			}
    			if (isForward){
    				oneAnswer.addFirst(tempWordBox.word);
    			}
				else{
					oneAnswer.addLast(tempWordBox.word);
				}
    			
    			results.add(oneAnswer);
    		}
    		return results;
    	}else if ( level == minSteps[0] || level >  hmWordGraph.size())
    		return results;
    	
    	HashSet<String> allWords = hmWordGraph.get(oneWord.word);
    	for (String s: allWords){
    		if (shouldAdd(oneWord, s, hsNotComingBack)){
    			ll.add(new wordbox(s, end, oneWord, level));
    		}
    	}
    	return results;
	}
	
	private boolean shouldAdd(wordbox oneWord, String s, HashSet<String> hsNotComingBack){
		boolean result = true;
		wordbox w = oneWord;
		if (oneWord.ancestor == null)
			return true;
		if (hsNotComingBack.contains(s))
			result =  false;
		w = oneWord.ancestor;
		while (w != null ) {
			hsNotComingBack.add(w.word);
			if (s.equals(w.word)){
				result =  false;
			}
			w = w.ancestor;
		}
		return result;
	}
	*/
	
	static class Word {
		String word;
		Set<Word> next;
		boolean end;
		Word(String word){
			this.word = word;
		}
	}
	static class Trace {
		Word obj;
		Trace prev;
		Trace(Word obj,Trace prev){
			this.obj = obj;
			this.prev = prev;
		}
	}
	HashMap<String, Word> wmap;
	void connect(Word w, Set<String> dict){
		if(w.next != null) return;
		Set<Word> n = new HashSet<Word>();
		char[] ws = w.word.toCharArray();
		
		for(int i = 0; i < ws.length; i++){
			char t = ws[i];
			for(char r = 'a'; r <= 'z'; r++){
				ws[i] = r;
				String d = new String(ws);
				if(dict.contains(d)){
					Word c = wmap.get(d);
					n.add(c);
				}
			}
			ws[i] = t;
		}
		w.next = n;
	}
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> rt = new ArrayList<List<String>>();
		wmap = new HashMap<String, Word>();
	
		for(String d : dict){
			Word w = new Word(d);
			wmap.put(d, w);
		}
		
		Word _end = new Word(end);
		_end.end = true;
		wmap.put(end, _end);
		dict.add(end);
		Word _start = new Word(start);
		connect(_start, dict);
		
		final Trace SEP = new Trace(null, null);
		LinkedList<Trace> queue = new LinkedList<Trace>();
		
		for (Word word : _start.next) {
			queue.add(new Trace(word, null));
		}
		queue.add(SEP);
		boolean find = false;
		HashSet<Word> vi = new HashSet<Word>();
		HashSet<Word> svi = new HashSet<Word>();
		
		while(!queue.isEmpty()){
		Trace step = queue.poll();
		
		if(step == SEP) {
			vi.addAll(svi);
			svi.clear();
			queue.add(SEP);
			if (find) break;
			if (queue.peek() == SEP) break;
			continue;
		}
		
		Word word = step.obj;
		connect(word, dict);
		
		if(word.end){
			LinkedList<String> r = new LinkedList<String>();
			Trace t = step;
			while (t != null){
				r.addFirst(t.obj.word);
				t = t.prev;
			}
			r.addFirst(start);
			rt.add(r);
			find = true;
		}else if(!find){
			for (Word p : word.next) {
				if(!vi.contains(p)) {
					queue.add(new Trace(p, step));
					svi.add(p);
				}
			}
		}
		}
		return rt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLadders llen = new findLadders();
		Scanner sIn = new Scanner(System.in);
		String start = sIn.nextLine().trim();
		String end = sIn.nextLine().trim();
		String oneline = sIn.nextLine().trim();
		String[] strs = oneline.split(",");
		sIn.close();
		HashSet<String> dict = new HashSet<String>();
		for (String s : strs)
			dict.add(s);
		long starttime = System.currentTimeMillis();
		System.out.println(llen.findLadders(start, end, dict));
		long endtime = System.currentTimeMillis();
		System.out.println((double)(endtime - starttime)/1000);
	}
}