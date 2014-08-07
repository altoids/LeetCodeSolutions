
import java.util.*;

public class PalindromePartitioningII {
	
	public int minCut(String s) {
		// looks like we need to find a much faster solution
		
		return 0;
	}
	/* this following solution fails the longest test string. looks like recursion is not going to work 
	HashMap<String, Integer> mapStringCost = new HashMap<String, Integer>();

	public int minCut(String s) {
		int cuts = s.length() - 1;
		String ls = "";
		String lsub = "";
		Integer subMinCut;

		if (isPalindrome(s))
			return 0;
		
		for (int i = 0; i < s.length(); i++){
			if (cuts == 1)
					return cuts; // s itself isn't palindrome when we are here, so if cuts is 1, we are already the best. return here.

			ls += s.charAt(i);
			if (isPalindrome(ls))
			{
				lsub = s.substring(i+1);
				if (lsub.isEmpty())
					continue;
				
				subMinCut = mapStringCost.get(lsub);
				if (subMinCut == null)
				{
					subMinCut = minCut(lsub);
					mapStringCost.put(lsub, subMinCut);
				}
				
				if (cuts > subMinCut + 1)
					cuts = subMinCut + 1; 
			}

		}
		return cuts;
	}
	
	private boolean isPalindrome(String s)
	{
	    int len = s.length();
		if (s.isEmpty())
			return true;
		boolean isPalindrome2 = true;
		for (int i = 0; i < len/2; i++)
		{
			char sfront = s.charAt(i);
			char sback = s.charAt(len - i - 1);
			if (sfront != sback)
			{
				// found bad sequence, bail
				isPalindrome2 = false;
				break;
			}
		}
		return isPalindrome2;
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toString());
		date = null;
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String teststring = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(pp.minCut(teststring));
		//System.out.println(pp.minCut("aab"));
		date = new Date();
		System.out.println(date.toString());
		System.out.println(teststring.length());
		
	}

}
