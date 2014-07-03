
public class ValidPalindrome {

    public boolean isPalindrome(String s)
	{
		if (s.isEmpty())
			return true;
		s = s.toLowerCase();
		int front = 0;
		int back = s.length()-1;
		
		while (front <back)
		{
			while (front <s.length() && !isalphanumeric(s.charAt(front)) )
				front++;
			while (back >=0 && !isalphanumeric(s.charAt(back)))
				back--;
			if (front < back && s.charAt(front) != s.charAt(back))
				return false;
			if (front >= back)
				return true;
			front++;
			back--;
			
		}
		
		return true;
	}
	
	private boolean isalphanumeric(char c)
	{
		if ((c>='a' && c<='z') || (c>='0' && c<='9'))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		String s = "abcba";
		System.out.println(vp.isPalindrome(s));
		
		
		// TODO Auto-generated method stub

	}

}
