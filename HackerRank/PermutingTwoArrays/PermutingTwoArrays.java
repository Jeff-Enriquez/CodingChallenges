import java.util.*;
// https://www.hackerrank.com/challenges/two-arrays/problem
public class PermutingTwoArrays {
	
	/*
	 * Time Complexity: O(a*log(a) + b*log(b) + a) where a is the size of "A" array and b is the size of "B" array.
     *                      -> we can drop the smaller time complexity
     *                      -> O(a*log(a) + b*log(b))
     *                      -> we don't need 'a' and 'b' because we know that "A" and "B" will always be the same size
	 * 						-> O(n*log(n))
	 * Space Complexity: O(a + b)
	 * 						-> O(n) we can reduce because we know that "A" and "B" will always be the same size
	 */
	public static String solution(int k, List<Integer> A, List<Integer> B) {
		// Sort array "A" in ascending order
        Collections.sort(A); // Uses tim sort
        // Sort array "B" in descending order
        Collections.sort(B, (a, b) -> b - a); // Uses tim sort
        // Loop through both arrays
        for(int i = 0; i < A.size(); i++){
        	// Confirm that the sum is at least equal to k
            if(A.get(i) + B.get(i) < k)
                return "NO";
        }
        return "YES";
    }
	
}
