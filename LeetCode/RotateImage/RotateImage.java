/*
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Constraints:
 *      n == matrix.length == matrix[i].length
 *      1 <= n <= 20
 *      -1000 <= matrix[i][j] <= 1000
 * 
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 *      k = total number of elements in matrix
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int currLoop = 0; currLoop < n / 2; currLoop++) {
            int numOfShifts = matrix.length - 1 - (2 * currLoop);
            for(int i = 0; i < numOfShifts; i++) {
                // Save top left
                int temp = matrix[currLoop][i + currLoop];
                // Move bottom left to top left
                matrix[currLoop][i + currLoop] = matrix[n - 1 - i - currLoop][currLoop];
                // Move bottom right to bottom left
                matrix[n - 1 - i - currLoop][currLoop] = matrix[n - 1 - currLoop][n - 1 - i - currLoop];
                // Move top right to bottom right
                matrix[n - 1 - currLoop][n - 1 - i - currLoop] = matrix[i + currLoop][n - 1 - currLoop];
                // Move saved top left to top right
                matrix[i + currLoop][n - 1 - currLoop] = temp;
            }
        }
    }
}
