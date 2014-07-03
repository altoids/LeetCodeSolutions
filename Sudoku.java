

import java.util.*;
import java.math.*;

public class Sudoku {
	public boolean solveSudoku(int[][] grid, int n){
		int[] xypair = {-1, -1};
		if (!findUnassignedCell(grid, n, xypair ))
			return true; //we are done here
		for (int i = 1; i<=n; i++)
		{
			if (isSafe(grid, n, xypair, i))
			{
				grid[xypair[0]][xypair[1]] = i;
				if (solveSudoku(grid,n))
					return true;
			}
			grid[xypair[0]][xypair[1]] = -1;
		}
		return false;
	}
	private boolean isSafe(int[][] grid, int n, int[] xypair, int value)
	{
		for (int i = 0; i<n; i++)
		{
			if (grid[xypair[0]][i] == value && i != xypair[1])
				return false;
			if (grid[i][xypair[1]] == value && i!= xypair[0])
				return false;
		}
		
		int sizeOfSmallSquare = (int) Math.sqrt(n);
		int startPointX = (xypair[0]/sizeOfSmallSquare)*sizeOfSmallSquare;
		int startPointY = (xypair[1]/sizeOfSmallSquare)*sizeOfSmallSquare;
		
		for (int i = startPointX; i<startPointX+sizeOfSmallSquare; i++)
		{
			for (int j = startPointY; j<startPointY+sizeOfSmallSquare; j++){
				if (i!=xypair[0] && j != xypair[1] && grid[i][j] == value)
					return false;
			}
		}
		return true;
		

	}
	private boolean findUnassignedCell(int[][] grid, int n, int[] xypair)
	{
		for (int i=0; i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if (grid[i][j] == -1) //-1 means unassigned
				{
					xypair[0] = i; // 0 element is x
					xypair[1] = j; // 1 element is y
					return true;
				}
			}
		}
		return false;
	}
}
