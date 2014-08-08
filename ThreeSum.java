import java.util.*;


public class ThreeSum {

	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
	public LinkedList<LinkedList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		LinkedList<LinkedList<Integer>> llll = new LinkedList<LinkedList<Integer>>(); 
		for (int i = 0; i< num.length; i++) hm.put(num[i], i);
		for (int i = 0; i<num.length; i++){
			if (i > 0 && num[i] == num[i-1]) continue;
			for (int j = i+1; j<num.length; j++){
				if (j > i+1 && num[j] == num[j-1]) continue;
				if (hm.containsKey(0-num[i] - num[j])){
					if (hm.get(0-num[i]-num[j]) > j){
						// we found a match
						LinkedList<Integer> ll = new LinkedList<Integer>();
						ll.add(num[i]);
						ll.add(num[j]);
						ll.add(0-num[i] - num[j]);
						llll.add(ll);
					}
						
				}
			}
		}
		return llll;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeSum ts = new ThreeSum();
		int[] num = {1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 3,1, -4, 2, 31, -4, 2, 3,1, -4, 2, 3};
		LinkedList<LinkedList<Integer>> llll = ts.threeSum(num);
		for (LinkedList<Integer> ll : llll){
			for (Integer i : ll){
				System.out.print(i + ",");
			}
			System.out.println("");
		}
		

	}

}
