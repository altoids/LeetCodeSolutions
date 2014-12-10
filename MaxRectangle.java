/*
 * Maximal Rectangle Total Accepted: 15590 Total Submissions: 72870 My Submissions Question Solution 
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaxRectangle {

	public int maximalRectangle(char[][] matrix) {
		int maxArea = 0;
		int ROW = matrix.length;
		int COL = ROW > 0?matrix[0].length:0; 
		int currentArea = 0;
		for (int i = 0; i<ROW; i++) {
			for (int j = 0; j<COL; j++) {
				if (matrix[i][j] == '1') {
					currentArea = getArea(i, j, ROW, COL, matrix);
					if (currentArea > maxArea)
						maxArea = currentArea;
				}
			}
		}
		return maxArea;        
    }
	
	private int getArea(int row, int col, int ROW, int COL, char[][] m) {
		int minCommonLen = Math.max(ROW, COL)+1;
		boolean failed = false;
		int i = row;
		for (; i<ROW && !failed; i++) {
			int j = col;
			for (; j<COL && j < col+minCommonLen && !failed ; j++) {
				if (j == col && m[i][j] != '1')
					failed = true;
				if (m[i][j] != '1')
					break;
			}
			if (!failed && j<minCommonLen+col)
				minCommonLen = j - col;
		}
		return minCommonLen * (i-row-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxRectangle mr = new MaxRectangle();
		char[][] m = {{'0','0','0'},{'0','1','1'},{'0','1','1'},{'0','1','0'}};
		System.out.println(mr.maximalRectangle(m));
	}

}
