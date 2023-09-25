import java.util.List;
// https://www.hackerrank.com/challenges/flipping-the-matrix/problem
public class FlippingTheMatrix {
    /*
	 * Time Complexity: O(n) where n is the size of the matrix
	 * Space Complexity: O(1)
	 */
	public static int solution(List<List<Integer>> matrix) {
		// The matrix size of the upper-left quadrant 
		int n = matrix.size() / 2;
		// The last index of the matrix
		int lastIndex = matrix.size() - 1;

		int maximumSum = 0;

		// Loop through every row of the upper-left quadrant
		for(int i = 0; i < n; i++) {
			// Loop through every column of the upper-left quadrant
			for(int j = 0; j < n; j++) {
				// The largest number of the quadrant position
				int largestNum;
				
				// Get the value of the current quadrant element
				int currentPosition = matrix.get(i).get(j);
				largestNum = currentPosition;
				
				// Get the value opposite-right of the current quadrant element
				int oppositeRight = matrix.get(i).get(lastIndex - j);
				largestNum = Math.max(largestNum, oppositeRight);
				
				// Get the value opposite-below of the current quadrant element
				int oppositeBelow = matrix.get(lastIndex - i).get(j);
				largestNum = Math.max(largestNum, oppositeBelow);
				
				// Get the value opposite-across of the current quadrant element
				int oppositeAcross = matrix.get(lastIndex - i).get(lastIndex - j);
				largestNum = Math.max(largestNum, oppositeAcross);
				
				maximumSum += largestNum;
			}
		}
		return maximumSum;
	}
}