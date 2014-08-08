
public class divide {
	public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        
		long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);
        
        int shifts = 0;
        while (x >= (y<<shifts)) shifts++;
        
        long result = 0;
        long remain = x;
        int i = shifts;
        while (remain >= 0 && i >=0) {
        	long attempt = remain - (y<<i);
        	if (attempt < 0)
        			i --;
        	else {
        		remain -= (y<<i);	
        		result += (1 << i);
        	}
        }
        return (int) ((dividend > 0 && divisor > 0 || dividend <0 && divisor <0) ? result : result * -1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divide d = new divide();
		System.out.println(-1/1);
		System.out.println(d.divide(-1, 1));

	}

}
