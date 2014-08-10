import java.util.*;

public class anagrams {
	
	public List<String> anagrams(String[] strs) {
        ArrayList<String> ll = new ArrayList<String>();
        boolean[] visited = new boolean[strs.length];
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        
        
        for (int i = 0; i< strs.length; i++){
        	char[] tempchararray = strs[i].toCharArray();
        	Arrays.sort(tempchararray);
        	String tempStr = new String(tempchararray);
        	if (hm.containsKey(tempStr)){
        		hm.get(tempStr).add(strs[i]);
        	}
        	else{
        		ArrayList<String> al = new ArrayList<String>();
        		al.add(strs[i]);
        		hm.put(tempStr, al);
        	}
        }
        
        for (String key : hm.keySet()){
        	if (hm.get(key).size() > 1)
        		ll.addAll(hm.get(key));
        }
        return ll;
        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		String[] strs = sIn.nextLine().split(",");
		anagrams a = new anagrams();

		long start = System.currentTimeMillis(); 
		List<String> ll = a.anagrams(strs);
		long end = System.currentTimeMillis();
		for (String s : ll){
			System.out.println(s);
		}
		System.out.println(((double)(end-start))/1000);
		sIn.close();
	}

}
