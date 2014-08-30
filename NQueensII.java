import java.util.LinkedList;
import java.util.List;

/*
 * N-Queens II Total Accepted: 12003 Total Submissions: 36169 My Submissions
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.


 */
public class NQueensII {

	public int totalNQueens(int n) {
		String[] board = new String[n];
		for (int i = 0; i<n; i++)
			initializeString(board, i);
		return solveNQueensInternal(board, 0);
    }
	
	private int solveNQueensInternal(String[] board, int row){
		if (row >= board.length)
			return 0;
		int result = 0;
		for (int j = 0; j<board.length;j++){
			char[] cset = board[row].toCharArray();
			boolean changed = false;
        	if (isGoodPosition(board, row, j)){
        		cset[j] = 'Q';
        		board[row] = String.copyValueOf(cset);
        		if (row == board.length-1){
        			// found a soluton,copy the board
        			result++;
        		}
        		changed = true;
        	}
        	if (changed){
        		result += solveNQueensInternal(board, row+1);
        		cset[j] = '.';
        		board[row] = String.copyValueOf(cset);
        	}
        }
		return result;
	}
	
	private void initializeString(String[] ss, int row){
		String template = "";
		for (int i = 0; i< ss.length; i++){
			template = template + ".";
		}
		ss[row] = "" + template;
		return;
	}
	private boolean isGoodPosition(String[] board, int row, int col){
		if (board[row].charAt(col) == 'Q')
			return false;
		// no need to check row
		//vertical check
		for (int i = 0; i<board.length; i++)
			if (board[i].charAt(col) == 'Q' && i != row)
				return false;
		// check diagonal
		int temprow = row;
		int tempcol = col;
		// top right
		while (tempcol <= board.length-1 && temprow >= 0){
			if (board[temprow--].charAt(tempcol++) == 'Q')
				return false;
		}
		//top left
		temprow = row;
		tempcol = col;
		while (tempcol >= 0 && temprow >= 0){
			if (board[temprow--].charAt(tempcol--) == 'Q')
					return false;
		}
		// no need for bottom direction
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII n = new NQueensII();
		System.out.println(n.totalNQueens(13));
	}

}
