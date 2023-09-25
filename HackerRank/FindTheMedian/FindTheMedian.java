import java.util.*;
// https://www.hackerrank.com/challenges/find-the-median/problem
public class FindTheMedian {
    /*
     * Time Complexity: O(n*log(n))
     * Space Complexity: O(n)
     */
    public static int solution(List<Integer> arr) {
        // Sort the array
        Collections.sort(arr);
        // Return the median (middle element of the array)
        return arr.get(arr.size()/2);
    }
}
