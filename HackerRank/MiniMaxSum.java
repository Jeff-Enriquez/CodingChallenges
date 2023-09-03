import java.util.*;

// https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MiniMaxSum {
	
	/*
	 * Solution with for loop
	 * Time Complexity: O(1): Since the array size will always be 5, the time is constant 
	 * Space Complexity O(1): Since the array size will always be 5, the space is constant
	 */
	public static void solution1(List<Integer> arr) {
		// We will iterate through the array, adding the sum, and keep track of the min / max elements.
		
		// The max value an element in the array can be is 10^9. We will set the minNum to Long.MAX_VALUE (2^63 - 1) which is greater than 10^9.
		long minNum = Long.MAX_VALUE;
		// The min value an element in the array can be is 1 so we will set the maxNum to 0.  
		long maxNum = 0;
		
		// Get the sum of the array
		long arrSum = 0;
		for(int i = 0; i < arr.size(); i++) {
			// Get the current element of the array
			long currentNum = arr.get(i);
			// Add to the sum
			arrSum += currentNum;
			// Check if this element is the smallest number in the array
			if(currentNum < minNum)
				minNum = currentNum;
			// Check if this element is the largest number in the array
			if(currentNum > maxNum) {
				maxNum = currentNum;
			}
		}
		
		// The min value is the sum of the array minus the largest element.
		long minSum = arrSum - maxNum;
		// The max value is the sum of the array minus the smallest element.
		long maxSum = arrSum - minNum;
		
		// Print result
		System.out.println(minSum + " " + maxSum);
	}
	
	/*
	 * Solution with Merge Sort and for loop
	 * Time Complexity: O(1): Since the array size will always be 5, the time is constant 
	 * Space Complexity O(1): Since the array size will always be 5, the space is constant
	 */
	public static void solution2(List<Integer> arr) {
		// The requirements for the min/max sum must allow for 10^9. The primitive type "long" meets this requirement.
		long minSum = 0;
		long maxSum = 0;
		
		// If the array is sorted we only need to calculate the first four digits and the last four digits.
		// There are many sorting algorithms to choose from. To learn more visit https://www.geeksforgeeks.org/sorting-algorithms/
		// Rather than write our own sorting algorithm we will use one provided by the java library. Collections.sort() uses the Merge Sort algorithm. The time complexity for Merge Sort is O(nlogn).
		// Best practice: Do not modify the original array (unless that is the expectation)
		List<Integer> sortedArr = new ArrayList<>(arr);
		Collections.sort(sortedArr);

		// Get the sum of the array
		long arrSum = 0;
		for(int i = 0; i < sortedArr.size(); i++) {
			arrSum += sortedArr.get(i);
		}
		// Get the min by subtracting the largest number from the sum
		maxSum = arrSum - sortedArr.get(0);
		// Get the max by subtracting the smallest number from the sum
		minSum = arrSum - sortedArr.get(4);
		
		// Result
		System.out.println(minSum + " " + maxSum);
    }
	
}
