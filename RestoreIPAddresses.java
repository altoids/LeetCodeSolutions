import java.util.*;

public class RestoreIPAddresses {
	
	private boolean isValidIpSegment(String s) {
		if (Integer.parseInt(s) > 255 || (s.startsWith("0") && s.length() > 1))
			return false;
		return true;
	}

	public List<String> restoreIpAddresses(String s) {
		
		List<String> result = new ArrayList<String>();
		int slen = s.length();
        for (int l1 = 0; l1 < Math.min(3, slen-1); l1 ++) {
        	// level 1
        	String subStr1 = s.substring(0, l1+1);
        	if (!isValidIpSegment(subStr1))
        		continue;
        	for (int l2 = l1+1; l2 < Math.min(l1 + 4, slen-1); l2 ++) {
        		// level 2
            	String subStr2 = s.substring(l1+1, l2+1);
            	if (!isValidIpSegment(subStr2))
            		continue;
        		for (int l3 = l2 + 1; l3 < Math.min(l2 + 4, slen-1); l3 ++) {
        			// level 3
                	String subStr3 = s.substring(l2+1, l3+1);
                	if (!isValidIpSegment(subStr3))
                		continue;
        				// level 4
        			String subStr4 = s.substring(l3+1,slen);      
        			if (subStr4.length() <= 0 || subStr4.length() > 3)
        				continue;
                   	if (!isValidIpSegment(subStr4))
                   		continue;
        			String validAddress = subStr1 + "." + subStr2 + "." + subStr3 + "." + subStr4;
                   	result.add(validAddress);
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses ria = new RestoreIPAddresses();
		List<String> results = ria.restoreIpAddresses("00000");
		for (String s : results) {
			System.out.println(s);
		}
		
	}

}
