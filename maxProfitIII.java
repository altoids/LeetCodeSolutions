
public class maxProfitIII {
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
	public int maxProfit(int[] prices) {
		if (prices.length <=0)
			return 0;
        int[] minmax = getMinMaxIndex(0, prices.length-1, prices, true);
        int[] minmax2 = getMinMaxIndex(0, minmax[0], prices, true);
        int[] minmax3 = getMinMaxIndex(minmax[1], prices.length - 1, prices, true);
        int[] minmax4 = getMinMaxIndex(minmax[1], minmax[0], prices, false);
        int maxp1 = prices[minmax[1]] - prices[minmax[0]] + prices[minmax2[1]] - prices[minmax2[0]];
        int maxp2 = prices[minmax[1]] - prices[minmax[0]] + prices[minmax3[1]] - prices[minmax3[0]];
        int maxp3 = prices[minmax[1]] - prices[minmax4[1]] + prices[minmax4[0]] - prices[minmax[0]];
        
        if (maxp1 >= maxp2 && maxp1 >= maxp3)
        	return maxp1;
        else if(maxp2 >= maxp1 && maxp2 >= maxp3)
        	return maxp2;
        else if(maxp3 >= maxp1 && maxp3 >= maxp2)
        	return maxp3;
        else 
        	return maxp1;
        
    }
	
	private int[] getMinMaxIndex(int start, int end, int[] prices, boolean isForward){
		int minIndex = start;
        int tempMinIndex = start;
        int maxIndex = end;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = start; isForward?i<= end:i>=end; i+=(isForward ? 1: -1)){
        	if (prices[tempMinIndex] > prices[i])
        		tempMinIndex = i;

        	if (prices[i] - prices[tempMinIndex] > maxProfit){
        		maxProfit = prices[i] - prices[tempMinIndex];
        		minIndex = tempMinIndex;
        		maxIndex = i;
        	}
        }
        int[] results = {isForward?minIndex:maxIndex, isForward?maxIndex:minIndex};
        
        return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxProfitIII m = new maxProfitIII();
		//int[] input = {1,2,1, 2,1,1};
		//int[]  input = {1, 2};
		//int[] input = {1,4,2};
		int[] input = {6,1,3,2,4,7};
		System.out.println(m.maxProfit(input));
	}

}
