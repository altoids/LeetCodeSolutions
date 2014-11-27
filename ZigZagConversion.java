import java.util.*;
/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Check this:

https://oj.leetcode.com/discuss/1212/expected-output-of-abcde-4

A       G
|     / |
B    F  H
|   /   |
C  E    i
| /
D
 
 */

public class ZigZagConversion {

	public String convert(String s, int nRows) {
		List<StringBuilder> lsb = new ArrayList<StringBuilder>(nRows);
		for (int i = 0; i< nRows; i++)
			lsb.add(new StringBuilder());
		int count = 0;
		int step = 1;
		if (nRows == 0)
			return null;
		if (nRows == 1)
			return s;
		for (char c : s.toCharArray()) {
			StringBuilder sb = lsb.get(count);
			sb.append(c);
			lsb.set(count, sb);
			count += step;
			if (count == nRows) {
				step = -1;
				count -= 2;
			}
			if (count == -1) {
				step = 1;
				count +=2;
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i<nRows; i++) {
			result.append(lsb.get(i));
		}
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("a", 2));

	}

}
