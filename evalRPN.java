import java.util.*;


public class evalRPN {

	// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	
	public int evalRPN(String[] tokens){
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i = 0; i < tokens.length; i++){
			if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
				s.push(Integer.parseInt(tokens[i]));
			else {
				int v2 = s.pop();
				int v1 = s.pop();
				if (tokens[i].equals("+"))
					s.push(v1 + v2);
				else if(tokens[i].equals("-"))
					s.push(v1-v2);
				else if(tokens[i].equals("*"))
					s.push(v1 * v2);
				else if(tokens[i].equals("/"))
					s.push(v1/v2);
			}
		}
		return s.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		evalRPN e = new evalRPN();
		String[] sar = {"0","3","/"};
		System.out.println(e.evalRPN(sar));
		

	}

}
