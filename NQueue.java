/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
import java.util.*;
public class NQueue {

	public List<String[]> solveNQueens(int n) {
		String[] board = new String[n];
		for (int i = 0; i<n; i++)
			initializeString(board, i);
		List<String[]> result = new LinkedList<String[]>(); 
		solveNQueensInternal(board, 0, result);
		return result;
    }
	
	private void solveNQueensInternal(String[] board, int row, List<String[]> result){
		if (row >= board.length)
			return;
		for (int j = 0; j<board.length;j++){
			char[] cset = board[row].toCharArray();
			boolean changed = false;
        	if (isGoodPosition(board, row, j)){
        		cset[j] = 'Q';
        		board[row] = String.copyValueOf(cset);
        		if (row == board.length-1){
        			// found a soluton,copy the board
        			String[] newBoard = board.clone();
        			result.add(newBoard);
        		}
        		changed = true;
        	}
        	if (changed){
        		solveNQueensInternal(board, row+1,result);
        		cset[j] = '.';
        		board[row] = String.copyValueOf(cset);
        	}
        }
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

		NQueue n = new NQueue();
		System.out.println(n.solveNQueens(13).size());
	}

}
