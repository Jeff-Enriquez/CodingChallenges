import java.util.*;
// https://projecteuler.net/problem=6
public class SumSquareDifference {

    /*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
	public static long solution(int n) {
        // "Sum of Squares" formula
		double sumOfSquares = (n*(n+1)*(2*n+1))/6.0;
        // Square the "Sum Of the first n natural numbers" formula
		double squareOfSum = Math.pow((n * n + n) / 2.0, 2);
		return (long) (squareOfSum - sumOfSquares);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(100));
	}
}
