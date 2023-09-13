import java.util.List;

public class LonelyInteger {
    /*
	 * Time Complexity: O(n^2), where n = the size of array "a"
	 * Space Complexity: O(1), the space used is constant
	 */
	public static int solution1(List<Integer> a) {
		// The answer can never be -1. If we return -1, something went wrong.
		int answer = -1;
		
		// Check every number in the array
		for(int i = 0; i < a.size(); i++) {
			// Get the current number in the array.
			int currentNum = a.get(i);
			// We will assume the number is lonely until proven otherwise.
			boolean isLonely = true;
			// Compare the current number to all numbers in the array to see if it is lonely.
			for(int j = 0; j < a.size(); j++) {
				// Do not compare the number to itself.
				// If the number is found at a different index, then it is not lonely.
				if(i != j && currentNum == a.get(j)) {
					isLonely = false;
					// The number is not lonely, there is no need to continue checking the rest of the numbers.
					break;
				}
			}
			// If the number is lonely, that is our answer
			if(isLonely) {
				answer = currentNum;
				// The answer was found, there is no need to check the rest of the array.
				break;
			}
		}
		
		return answer;
	}

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
