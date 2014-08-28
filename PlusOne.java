/*
 * Plus One Total Accepted: 17575 Total Submissions: 55744 My Submissions
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] result = null;
        for (int i = digits.length-1; i>=0; i--){
            int temp = digits[i] + carry;
            if (temp > 9)
                carry = 1;
            else
                carry = 0;
            digits[i] = temp % 10;
        }
        if (carry == 1){
            // copy to new array
            result = new int[digits.length + 1];
            for (int i = 1; i< result.length; i++)
                result[i] = digits[i-1];
            result[0] = 1;
            return result;
        }
        return digits;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
