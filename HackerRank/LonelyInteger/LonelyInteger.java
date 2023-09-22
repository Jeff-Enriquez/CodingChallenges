import java.util.List;

// https://www.hackerrank.com/challenges/lonely-integer/problem
public class LonelyInteger {

	/*
	 * Time Complexity: O(n), where n = the size of array "a"
	 * Space Complexity: O(1), the space used is constant
	 */
	public static int solution2(List<Integer> a) {
		// The answer can never be -1. If we return -1, something went wrong.
		int answer = -1;
		
		// Keep track of the count of each number found in array "a"
		int[] count = new int[101];
		
		// Loop through array "a" and increment the count of each number
		for(Integer currentNum : a) {
			count[currentNum]++;
		}
		
		// Loop through the count tracker to find the lonely integer
		for(int i = 0; i < count.length; i++) {
			// Lonely integer was found
			if(count[i] == 1) {
				answer = i;
				// The answer was found, there is no need to look through the rest of the array.
				break;
			}
		}
		
		return answer;
	}
}
