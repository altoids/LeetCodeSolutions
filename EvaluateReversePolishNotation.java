
import java.util.*;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack <Integer> st = new Stack();
        String sop1;
        String sop2;
        int iop1;
        int iop2;
        int tempresult;
        
        for (int i = 0; i<tokens.length; i++){
            if (!tokens[i].equals("+") 
                && !tokens[i].equals("-") 
                && !tokens[i].equals("*") 
                && !tokens[i].equals("/")){
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
                iop2 = (Integer)st.pop();
                iop1 = (Integer)st.pop();
                if (tokens[i].equals("+")){
                        tempresult = iop1 + iop2;
                        st.push(tempresult);
                }else if (tokens[i].equals("-")){
                        tempresult = iop1 - iop2;
                        st.push(tempresult);
                }else if (tokens[i].equals("*")){
                        tempresult = iop1 * iop2;
                        st.push(tempresult);
                }else if (tokens[i].equals("/")){
                        tempresult = iop1 / iop2;
                        st.push(tempresult);
                }
                
            }
        }

        return st.pop();
        
    }
}
