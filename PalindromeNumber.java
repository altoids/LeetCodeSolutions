
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int len = 1;
		long i = 10;
		if (x<0)
		return false;
		while (x/i !=0)
		{
			i *=10;
			len++;
		}
		for (i = 0;i<len/2;i++)
		{
			int left = x/((int) Math.pow(10, (len-i*2-1)));
			int right = x%10;
			if (left != right)
				return false;
			x = x%((int)Math.pow(10, (len-i*2-1)));
			x = x/10;
			
		}
		
		return true;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn = new PalindromeNumber();
		int x = 123214;
		System.out.println(pn.isPalindrome(x));
		
	}

}
