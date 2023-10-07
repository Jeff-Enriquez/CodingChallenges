import java.util.*;
// https://www.hackerrank.com/challenges/angry-children/problem
public class MaxMin {
    /* 
	 * Time Complexity: O(n * log(n)), where n = arr.size()
	 * Space Complexity: O(n)
	 */
	public static int maxMin(int k, List<Integer> arr) {
		// As of 2023-10-07, Collections.sort() uses TimSort
			// Time Complexity: O(n * log(n))
			// Space Complexity: O(n)
		Collections.sort(arr);
		int unfairness = Integer.MAX_VALUE;
		for(int i = 0; i < arr.size() - k + 1; i++) {
			int smallestNum = arr.get(i);
			int largestNum = arr.get(i + k - 1);
			if(unfairness > largestNum - smallestNum) {
				unfairness = largestNum - smallestNum;
			}
		}
		return unfairness;
    }
}
