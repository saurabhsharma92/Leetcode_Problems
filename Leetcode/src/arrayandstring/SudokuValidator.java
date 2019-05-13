package arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
	public static void main(String[] args) {
		char [][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(isValidSudoku(board));
	}
	
	public static boolean isValidSudoku(char[][] board) {
	    for(int i=0; i<board.length; i++){
	        Set<Character> rSet = new HashSet<>(), cSet = new HashSet<>(), bSet = new HashSet<>();
	        for(int j=0; j<board.length; j++){
	            if(board[i][j] != '.' && !rSet.add(board[i][j])) return false;
	            if(board[j][i] != '.' && !cSet.add(board[j][i])) return false;
	            int r = i/3 * 3 + j/3 , c = i%3 * 3 + j%3;
	            if(board[r][c] != '.' && !bSet.add(board[r][c])) return false;
	        }
	    }
	    return true;
	}
}
