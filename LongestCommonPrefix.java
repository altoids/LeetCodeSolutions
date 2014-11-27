/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

import java.util.*;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int bitIndex = 0;
        boolean reachedEnd = false;
        if (strs.length <= 0)
            return "";
        while (!reachedEnd && bitIndex < strs[0].length()) {
            for (int i = 1; i< strs.length; i++) {
                if (strs[i].length() == bitIndex 
                    || strs[i-1].length() == bitIndex 
                    || strs[i].charAt(bitIndex) != strs[i-1].charAt(bitIndex) ){
                        reachedEnd = true;
                        break;
                    }
            }
            bitIndex++;
        }
        if (reachedEnd)
        	bitIndex--;
        return strs[0].substring(0,bitIndex);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] sa = {""};
		System.out.println(lcp.longestCommonPrefix(sa));
	}

}
