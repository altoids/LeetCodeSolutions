
public class divide {
	public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == Integer.MIN_VALUE) return 0;
        
		long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);
        
        int shifts = 0;
        while (x > (y<<shifts)) shifts++;
        
        long result = (shifts > 0) ? (1<<shifts) : 0;
        long remain = x - (y<<shifts);
        int i = 2;
        while (remain < 0) {
        	remain = remain + (y<<(shifts - i));
        	result -= (1 << (shifts - i));
        	i++;
        }
        while (remain <0){
        	remain = remain+y;
        	result --;
        }
        return (int) ((dividend > 0 && divisor > 0 || dividend <0 && divisor <0) ? result : result * -1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		divide d = new divide();
		System.out.println(-2147483648/-3);
		System.out.println(d.divide(-2147483648, -3));

	}

}
