import java.util.*;
/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
 */

public class countAndSay {

	public String countAndSay(int n) {
        char[] chs = String.valueOf(1).toCharArray();
        String result = null;
        for (int i = 1; i<n; i++)
        	chs = countAndSay(chs);
        result = new String(chs);
        return result;
    }
	
	private char[] countAndSay(char[] chs) {
		 StringBuilder sb = new StringBuilder();
		 for (int i = 0; i< chs.length; i++) {
			 int count = 0;
			 char currc = chs[i];
			 while ((i+count < chs.length) && (chs[i+count] == currc))
				 count ++;
			 i += count -1;
			 sb.append(String.valueOf(count));
			 sb.append(currc);
		 }
		 return sb.toString().toCharArray();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay c = new countAndSay();
		System.out.println(c.countAndSay(1));
		System.out.println(c.countAndSay(2));
		System.out.println(c.countAndSay(3));
		System.out.println(c.countAndSay(4));

	}

}
