import java.util.Arrays;
import java.util.PriorityQueue;


public class maxProfit {

	public int maxProfit(int[] prices) {
        int maxp = 0;
        int lowestprice = Integer.MAX_VALUE;
        for (int i = 0; i< prices.length; i++){
            lowestprice = prices[i] < lowestprice? prices[i]: lowestprice;
            maxp = maxp < prices[i] - lowestprice? prices[i] - lowestprice: maxp;
        }
        return maxp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxProfit m = new maxProfit();
		int[] input = {2,1,1};
		System.out.println(m.maxProfit(input));
	}

}
