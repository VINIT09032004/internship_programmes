package internship_programmes;


class Sudoku {
	

	    // Check if placing a number in a specific cell is valid
	    private static boolean isValid(int[][] board, int row, int col, int num) {
	        // Check the row
	        for (int i = 0; i < 9; i++) {
	            if (board[row][i] == num) {
	                return false;
	            }
	        }

	        // Check the column
	        for (int i = 0; i < 9; i++) {
	            if (board[i][col] == num) {
	                return false;
	            }
	        }

	        // Check the 3x3 subgrid
	        int startRow = (row / 3) * 3;
	        int startCol = (col / 3) * 3;
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[startRow + i][startCol + j] == num) {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }

	    // Solve the Sudoku puzzle using backtracking
	    private static boolean solveSudoku(int[][] board) {
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                if (board[row][col] == 0) { // Find an empty cell
	                    for (int num = 1; num <= 9; num++) { // Try numbers from 1 to 9
	                        if (isValid(board, row, col, num)) {
	                            board[row][col] = num; // Place the number

	                            if (solveSudoku(board)) { // Recursively solve the rest
	                                return true;
	                            }

	                            board[row][col] = 0; // Backtrack if the solution is invalid
	                        }
	                    }
	                    return false; // Trigger backtracking
	                }
	            }
	        }
	        return true; // Puzzle is solved
	    }

	    // Print the Sudoku board
	    private static void printBoard(int[][] board) {
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                System.out.print(board[row][col] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Main method
	    public static void main(String[] args) {
	        // Example input grid (0 represents empty cells)
	        int[][] board = {
	            {5, 3, 0, 0, 7, 0, 0, 0, 0},
	            {6, 0, 0, 1, 9, 5, 0, 0, 0},
	            {0, 9, 8, 0, 0, 0, 0, 6, 0},
	            {8, 0, 0, 0, 6, 0, 0, 0, 3},
	            {4, 0, 0, 8, 0, 3, 0, 0, 1},
	            {7, 0, 0, 0, 2, 0, 0, 0, 6},
	            {0, 6, 0, 0, 0, 0, 2, 8, 0},
	            {0, 0, 0, 4, 1, 9, 0, 0, 5},
	            {0, 0, 0, 0, 8, 0, 0, 7, 9}
	        };

	        System.out.println("Unsolved Sudoku:");
	        printBoard(board);

	        if (solveSudoku(board)) {
	            System.out.println("\nSolved Sudoku:");
	            printBoard(board);
	        } else {
	            System.out.println("No solution exists.");
	        }
	    }


}
