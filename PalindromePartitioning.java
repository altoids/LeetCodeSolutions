
import java.math.*;
import java.util.*;

public class PalindromePartitioning {

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
	
	public static void main(String[] args) {
		
		Palindrome p = new Palindrome();
		String s = "c5nMro2nMfxtOveG9T?w?T_0C4KURCN?0PD82kE9hiECr0FHu:nd9i^3G9]:O4aXX`\\UWPTw?B25h:lX";
		List<List<String>> lls = p.partition(s);
		for (List<String> ls : lls)
		{
			for (String ss : ls)
				System.out.print(ss + ",");
			System.out.println("");
			System.out.println("----------------------------------------");
		}

	}

}
