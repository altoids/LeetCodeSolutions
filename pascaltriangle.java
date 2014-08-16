/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
import java.util.*;

public class pascaltriangle {

	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        for (int i = 0; i< numRows; i++){
        	List<Integer> li = new ArrayList<Integer>();
        	
        	if (i == 0){
        		li.add(1);
        	}else{
	        	for (int j = 0; j<i+1; j++){
	        		if (j == 0)
	        			li.add(j,0+ll.get(i-1).get(j));
	        		else if (j == i)
	        			li.add(j,ll.get(i-1).get(j-1) + 0);
	        		else
	        			li.add(j,ll.get(i-1).get(j-1)+ll.get(i-1).get(j));
	        	}
        	}
        	
        	ll.add(i, li);
        }
        
        return ll;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sIn = new Scanner(System.in);
		int N = sIn.nextInt();
		pascaltriangle pt = new pascaltriangle();
		System.out.println(pt.generate(N));
		sIn.close();

	}

}
