
import java.math.*;
import java.util.*;

public class Palindrome {
	
	public List<List<String>> partition(String s) {
        String ps = "";
        String psub = "";
        List<List<String>> llstring = null;
        for (int i=0;i<s.length();i++)
        {
        	List<List<String>> llstringLocal= null;
            ps = ps + s.charAt(i);
            psub = s.substring(i+1);
            if (!isPalindrome2(ps))
            	continue;
            llstringLocal = partition(psub);
            if (llstringLocal != null)
            {
                // we found one list of list of string that makes the right partition for psub
            	// append current ps to the list of strings
            	for(List<String> ls : llstringLocal)
            	{
            		ls.add(0, ps);
            		if (llstring != null)
            			llstring.add((List<String>) ls);
            	}
            	if (llstring == null)
            		llstring = llstringLocal;
            }
        }
        
        if (ps.equals(s) && !ps.isEmpty() && isPalindrome2(ps))
        {
        	// the entire input string is palindrome. construct a return value.
        	LinkedList<String> ls = new LinkedList<String>();
        	ls.add(s);
        	LinkedList<List<String>> lls = new LinkedList<List<String>>();
        	lls.add(ls);
        	if (llstring == null)
        		llstring = (List<List<String>>)lls;
        	else
        		llstring.addAll(lls);
        }
        return llstring;
    }
	
	private boolean isPalindrome2(String s)
	{
		if (s.isEmpty())
			return true;
		boolean isPalindrome2 = true;
		for (int i = 0; i < s.length(); i++)
		{
			char sfront = s.charAt(i);
			char sback = s.charAt(s.length() - i - 1);
			if (sfront != sback)
			{
				// found bad sequence, bail
				isPalindrome2 = false;
				break;
			}
		}
		return isPalindrome2;
	}
    
    private boolean isPalindrome(String s)
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
		return true;
		//if ((c>='a' && c<='z') || (c>='0' && c<='9'))
		//	return true;
		//else
		//	return false;
	}
	
	public boolean isPalindromeuseextraspace(int x)
	{
		int[] digits = new int[10];
		int i = 0;
		int len = -1;
		while (x/10 != 0)
		{
			digits[i] = x%10;
			i++;
			x=x/10;
		}
		digits[i] = x;
		len = i+1;
		
		for (i = 0;i<len/2;i++)
		{
			if (digits[i] != digits[len-i-1])
				return false;
			
		}
		return true;
	}
	
	public boolean isPalindromeInPlace(int x)
	{
		int len = 1;
		long i = 10;
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
}
