
public class LengthofLastWord {
	private boolean isAlphabet(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
            return true;
        return false;
    }
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int result = 0;
        boolean startCounting = false;
        boolean stopCounting = false;
        for (int i = len -1; i>=0; i--) {
            char curChar = s.charAt(i);
            if (!startCounting  && isAlphabet(curChar)){
                startCounting = true;
                result ++;
            } else if (!stopCounting && isAlphabet(curChar)) {
                result ++;
            }
            if (startCounting && !isAlphabet(curChar))
                break;
        }
        return result;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
