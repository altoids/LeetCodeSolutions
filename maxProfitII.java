
public class maxProfitII {

	public int maxProfit(int[] prices) {
		
		int result = 0;
		for (int i = 0; i< prices.length -1;i++){
			if (prices[i] < prices[i+1]) result += prices[i+1] - prices[i];
		}
		return result;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
