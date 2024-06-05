/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * 
 * Constraints:
 *      0 <= nums.length <= 10^5
 *      -10^9 <= nums[i] <= 10^9
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // Store longest consecutive sequence
        int longestConsec = 0;
        // Save all nums to a set
        Set<Integer> setOfNums = new HashSet<>();
        for(int n : nums)
            setOfNums.add(n);
        // Loop through all numbers
        int currConsec, prevN, nextN;
        for(int n : nums) {
            currConsec = 1;
            prevN = n - 1;
            nextN = n + 1;
            // Check all previous numbers sequentially
            while(setOfNums.remove(prevN--))
                currConsec++;
            // Check all following numbers sequentially
            while(setOfNums.remove(nextN++))
                currConsec++;
            // Check if current consecutive sequence is greatest
            if(currConsec > longestConsec)
                longestConsec = currConsec;
        }
        return longestConsec;
    }
}
