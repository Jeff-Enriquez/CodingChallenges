import java.util.*;
/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * 
 * Constraints:
 *      m == matrix.length
 *      n == matrix[0].length
 *      1 <= m, n <= 200
 *      -2^31 <= matrix[i][j] <= 2^31 - 1
 */
public class SetMatrixZeroes {
    /*
     * First Solution
     * Time Complexity: O(k)
     * Space Complexity: O(1)
     *      k = total elements in the matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        // Check if first row has any zeros
        for(int column = 0; column < n; column++)
            if(matrix[0][column] == 0) {
                isFirstRowZero = true;
                break;
            }
        // Check if first column has any zeros
        for(int row = 0; row < m; row++)
            if(matrix[row][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        // Check all rows and columns - except for the first one's
        // The first row/column is used as a flag to determine which row/columns should be set to zero
        for(int row = 1; row < m; row++)
            for(int column = 1; column < n; column++)
                if(matrix[row][column] == 0) {
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }
        // Set rows to zero. Skip first row - that is used to determine which columns to set to zero
        for(int row = 1; row < m; row++)
            if(matrix[row][0] == 0)
                for(int column = 0; column < n; column++)
                    matrix[row][column] = 0;
        // Set columns to zero. Skip first column - that is used to determine which rows to set to zero
        for(int column = 1; column < n; column++)
            if(matrix[0][column] == 0)
                for(int row = 0; row < m; row++)
                    matrix[row][column] = 0;
        // Set first row to zero if zero was initially present
        if(isFirstRowZero)
            for(int column = 0; column < n; column++)
                matrix[0][column] = 0;
        // Set first column to zero if zero was initially present
        if(isFirstColumnZero)
            for(int row = 0; row < m; row++)
                matrix[row][0] = 0;
    }
    /*
     * Second Solution
     * Time Complexity: O(k)
     * Space Complexity: O(k)
     *      k = total elements in the matrix
     */
    public void setZeroes2(int[][] matrix) {
        Set<Integer> zeroColumns = new HashSet<>();
        Set<Integer> zeroRows = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                if(matrix[row][column] == 0) {
                    zeroColumns.add(column);
                    zeroRows.add(row);
                }
            }
        }
        // Set columns to zero
        Iterator<Integer> iterator = zeroColumns.iterator();
        while (iterator.hasNext()) {
            int column = iterator.next();
            for(int row = 0; row < m; row++) {
                matrix[row][column] = 0;
            }
        }
        // Set rows to zero
        iterator = zeroRows.iterator();
        while (iterator.hasNext()) {
            int row = iterator.next();
            for(int column = 0; column < n; column++) {
                matrix[row][column] = 0;
            }
        }
    }
}
