import java.util.*;

// https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MiniMaxSum {
	
	/*
	 * Time Complexity: O(1) With the HackerRank constraint, the size of the array is always 5 making the time complexity constant.
     *                      Without the constraint, the time complexity would be O(n) where n = size of the array.
	 * Space Complexity O(1): Same reason as time complexity.
	 */
	public static void solution(List<Integer> arr) {
		// We will iterate through the array, adding the sum, and keep track of the min / max elements.
		
		// The smallest element in the array. It will begin with the first element in the array.
		long minNum = arr.get(0);
		// The largest element in the array. It will begin with the first element in the array.
		long maxNum = arr.get(0);
		// The sum begins with the first element in the array.
		long sum = arr.get(0);
		
		// Start at index 1 because we already checked index 0.
		for(int i = 1; i < arr.size(); i++) {
			// Get the current element of the array
			long currentNum = arr.get(i);
			// Add to the sum
			sum += currentNum;
			// Check if this element is the smallest number in the array
			if(currentNum < minNum)
				minNum = currentNum;
			// Check if this element is the largest number in the array
			else if(currentNum > maxNum) {
				maxNum = currentNum;
			}
		}
		
		// The min value is the sum of the array minus the largest element.
		long minSum = sum - maxNum;
		// The max value is the sum of the array minus the smallest element.
		long maxSum = sum - minNum;
		
		// Print result
		System.out.println(minSum + " " + maxSum);
	}
	

	// For executing sample questions
	public static void main(String[] args) {
		solution(List.of(1, 3, 5, 7, 9));
			// Expected result: 16 24
		solution(List.of(769082435, 210437958, 673982045, 375809214, 380564127));
			// Expected result: 10 14
	}
	
}