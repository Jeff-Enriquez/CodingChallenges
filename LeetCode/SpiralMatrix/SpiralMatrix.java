import java.util.*;

public class SpiralMatrix {
    /*
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * 
     * Constraints:
     *      m == matrix.length
     *      n == matrix[i].length
     *      1 <= m, n <= 10
     *      -100 <= matrix[i][j] <= 100
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int topBoundary = 0;
        int rightBoundary = matrix[0].length - 1;
        int bottomBoundary = matrix.length - 1;
        int leftBoundary = 0;
        while(topBoundary <= bottomBoundary && rightBoundary >= leftBoundary) {
            // Traverse from left to right (not including the last index)
            for(int i = leftBoundary; i < rightBoundary; i++)
                list.add(matrix[topBoundary][i]);
            // Traverse from top to bottom (including the last index)
            for(int i = topBoundary; i <= bottomBoundary; i++)
                list.add(matrix[i][rightBoundary]);
            // Confirm still within boundaries
            if(topBoundary < bottomBoundary && leftBoundary < rightBoundary) {
                // Traverse from right to left (not including the last index)
                for(int i = rightBoundary - 1; i > leftBoundary; i--)
                    list.add(matrix[bottomBoundary][i]);
                // Traverse from bottom to top (including the last index)
                for(int i = bottomBoundary; i > topBoundary; i--)
                    list.add(matrix[i][leftBoundary]);
            }
            // Enclose boundaries
            topBoundary++;
            rightBoundary--;
            bottomBoundary--;
            leftBoundary++;
        }
        return list;
    }
}
