/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
import java.util.*;

public class pascaltriangleII {
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> li = new ArrayList<Integer>();
		List<Integer> prevli = null;
		rowIndex++;
        for (int i = 0; i< rowIndex; i++){
        	li = new ArrayList<Integer>();
       	
        	if (i == 0){
        		li.add(1);
        		
        	}else{
	        	for (int j = 0; j<i+1; j++){
	        		if (j == 0)
	        			li.add(j,0+prevli.get(j));
	        		else if (j == i)
	        			li.add(j,prevli.get(j-1) + 0);
	        		else
	        			li.add(j,prevli.get(j-1)+prevli.get(j));
	        	}
        	}
        	
        	prevli = li;
        }
        
        return li;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int N = sIn.nextInt();
		pascaltriangleII pt = new pascaltriangleII();
		System.out.println(pt.getRow(N));
		sIn.close();

	}

}
