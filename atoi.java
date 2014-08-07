
public class atoi {
	
	
	public int atoi(String str){
		if (str.length() <= 0)
			return 0;
		
		int index = 0;
     	char curChar = str.charAt(index);
		int result = 0;
		boolean isNegative = false;
		while (isSpace(curChar)){ 
			index ++; //skip all leading spaces;
			if (index >= str.length()) return 0;
			curChar = str.charAt(index);
		}
		if (curChar == '-')
			isNegative = true;
		else if (!Character.isDigit(curChar) && curChar != '+')
			return 0; // first non space char is non digit or +/-
		else if(Character.isDigit(curChar))
			result = curChar - '0';
		index ++;
		if (index >= str.length()) return isNegative? result * -1: result;
		curChar = str.charAt(index);
		while (Character.isDigit(curChar)){
			int prevResult = result;
			result = result * 10 + curChar - '0';
			if ((result/10 - prevResult) != 0) // overflow
				return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
			
			index ++;
			if (index >= str.length()) return isNegative? result * -1 : result;
			curChar = str.charAt(index);
		}
		return isNegative? result * -1: result;
	}
	
	
	private boolean isSpace(char ch){
		if(ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n')
			return true;
		else
			return false;
	}
	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		atoi a = new atoi();
		System.out.println(a.atoi("10522545459"));
		//System.out.println(1052254545);
		//System.out.println(1052254545 * 10);
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);

	}

}
