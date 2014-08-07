
public class reverse {

	public int reverse(int x) {
		char[] xstr = String.valueOf(Math.abs(x)).toCharArray();
		for (int i = 0; i<xstr.length/2; i++){
			char temp = xstr[i];
			xstr[i] = xstr[xstr.length - i - 1];
			xstr[xstr.length - i - 1] = temp;
		}
		int result = Integer.parseInt(new String(xstr)); 
		return x>0?result:result * -1;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverse r = new reverse();
		System.out.println(r.reverse(21));
	}

}
