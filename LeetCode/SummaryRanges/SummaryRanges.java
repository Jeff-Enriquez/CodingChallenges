import java.util.*;
/*
 * You are given a sorted unique integer array nums. A range [a,b] is the set of all integers from a to b (inclusive). Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 *      "a->b" if a != b
 *      "a" if a == b
 * 
 * Constraints:
 *      0 <= nums.length <= 20
 *      -2^31 <= nums[i] <= 2^31 - 1
 *      All the values of nums are unique.
 *      nums is sorted in ascending order.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        // Traverse through all numbers
        for(int i = 0; i < nums.length; i++) {
            // Store the first number of range
            int firstNum = nums[i];
            // Find the next non-consecutive number after 'firstNum'
            while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1])
                i++;
            // Store the range
            if(firstNum != nums[i])
                list.add("" + firstNum + "->" + nums[i]);
            // Store the individual number
            else
                list.add("" + firstNum);
        }
        return list;
    }
}
