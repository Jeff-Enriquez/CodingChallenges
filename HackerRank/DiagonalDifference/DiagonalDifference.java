import java.util.List;

//https://www.hackerrank.com/challenges/diagonal-difference/problem
public class DiagonalDifference {
    
    /*
	 * Time Complexity: O(n), where n = arr.size()
	 * Space Complexity: O(1)
	 */
	public static int solution(List<List<Integer>> arr) {

        // Sums of the diagonals
		int leftToRightDiagonal = 0;
		int rightToLeftDiagonal = 0;
		
		// Left to right diagonal
		for(int i = 0; i < arr.size(); i++) {
			leftToRightDiagonal += arr.get(i).get(i);
		}
		
		// Right to left diagonal
		for(int i = 0; i < arr.size(); i++) {
			rightToLeftDiagonal += arr.get(i).get(arr.size() - 1 - i);
		}
		
        // Absolute difference of the diagonals
		return Math.abs(leftToRightDiagonal - rightToLeftDiagonal);
	}

}
