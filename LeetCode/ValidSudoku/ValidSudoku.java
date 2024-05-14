import java.util.*;
public class ValidSudoku {
    /*
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *      1. Each row must contain the digits 1-9 without repetition.
     *      2. Each column must contain the digits 1-9 without repetition.
     *      3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     *      - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     *      - Only the filled cells need to be validated according to the mentioned rules.
     * Constraints:
     *      board.length == 9
     *      board[i].length == 9
     *      board[i][j] is a digit 1-9 or '.'.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *      Given the constraints, the time is constant.
     */
    public boolean isValidSudoku(char[][] board) {
        // 0 - 9 are indexes 48 - 57 | . is index 46
        int[] digits;
        /** Check each row **/
        for(int row = 0; row < board.length; row++) {
            digits = new int[58];
            // Count the digits
            for(int column = 0; column < board.length; column++) {
                digits[board[row][column]]++;
            }
            // Confirm no repetition
            for(int i = 48; i <= 57; i++) {
                if(digits[i] > 1)
                    return false;
            }
        }
        /** Check each column **/
        for(int column = 0; column < board.length; column++) {
            digits = new int[58];
            // Count the digits
            for(int row = 0; row < board.length; row++) {
                digits[board[row][column]]++;
            }
            // Confirm no repetition
            for(int i = 48; i <= 57; i++) {
                if(digits[i] > 1)
                    return false;
            }
        }
        /** Check each grid **/
        int rowRange = 0;
        while(rowRange < board.length) {
            int columnRange = 0;
            // Get each grid of current row
            while(columnRange < board.length) {
                digits = new int[58];
                // Loop through each row of grid (rowRange to rowRange + 3)
                for(int row = rowRange; row < rowRange + 3; row++) {
                    // Loop through each column of grid (columnRange to columnRange + 3)
                    for(int column = columnRange; column < columnRange + 3; column++) {
                        digits[board[row][column]]++;
                    }
                }
                // Confirm no repetition within grid
                for(int i = 48; i <= 57; i++) {
                    if(digits[i] > 1)
                        return false;
                }
                // Get the next grid to the left of current grid
                columnRange += 3;
            }
            // Get the next row of grids
            rowRange += 3;
        }
        return true;
    }
}
