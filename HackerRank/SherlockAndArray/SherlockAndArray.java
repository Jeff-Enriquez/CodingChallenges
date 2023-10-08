import java.util.*;
// https://www.hackerrank.com/challenges/sherlock-and-array/problem
public class SherlockAndArray {
    /*
	 * Time Complexity: O(2n) -> O(n)
	 * Space Complexity: O(1)
	 */
	public static String balancedSums(List<Integer> arr) {
		if(arr.size() == 1)
            return "YES";
		int totalSum = arr.stream().reduce(0, (num1, num2) -> num1 + num2);
		int leftSum = 0;
		int rightSum = totalSum;
		int idx = 0;
		
		do {
			int currentNum = arr.get(idx);
			rightSum -= currentNum;
			if(leftSum == rightSum)
				return "YES";
			leftSum += currentNum;
		} while(++idx < arr.size());
		return "NO";
    }
}
