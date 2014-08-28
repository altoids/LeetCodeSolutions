/*
 * Decode Ways Total Accepted: 14301 Total Submissions: 89412 My Submissions
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

import java.util.*;
public class DecodeWays {

	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	public int numDecodings(String s) {
        if (s.length() == 0 || s == null)
        	return 0;
        if (s.length() == 1 && !s.equals("0"))
        	return 1;
        else if(s.equals("0"))
        	return 0;
		if(hm.containsKey(s))
        	return hm.get(s);
        int result = 0;
        // s.length >=2 from here
        if (s.charAt(0) != '0'){
        	result = numDecodings(s.substring(1));
        	if (result <=0)
        		result = 0;
        }
        
        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && Integer.parseInt(s.substring(1,2 )) <=6)){
        	int temp = numDecodings(s.substring(2));
        	if (temp > 0 && s.length() != 2){
        		result += numDecodings(s.substring(2));
        		//result++; 
        	}else if (s.length() == 2)
        		result ++;
        }
        hm.put(s, result);
        return result;	
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d = new DecodeWays();
		String s = "12155";
		System.out.println(d.numDecodings(s));
	}

}
