import java.util.Arrays;


public class longestConsecutive {

	public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int longestcount = 1;
        int count = 1;
        for (int i = 1; i<num.length;i++){
            
            if (num[i] - num[i-1] == 1){
                count++;
                if (count > longestcount)
                    longestcount = count;
            }
            else if (num[i] == num[i-1])
                continue;
            else
                count = 1;
            
        }
        return longestcount;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
