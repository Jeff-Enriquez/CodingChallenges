import java.util.*;
/*
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 * 
 * Constraints:
 *      0 <= intervals.length <= 10^4
 *      intervals[i].length == 2
 *      0 <= starti <= endi <= 10^5
 *      intervals is sorted by starti in ascending order.
 *      newInterval.length == 2
 *      0 <= start <= end <= 10^5
 * 
 * Time Complexity: O(k)
 * Space Complxity: O(k)
 *      k = total number of integers in intervals
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /** Shared variable to get solution  **/
        int[][] result = new int[intervals.length + 1][2];
        int rIdx = 0;
        int iIdx = 0;

        /** Add all intervals smaller than the new interval **/
        while(iIdx < intervals.length && intervals[iIdx][1] < newInterval[0])
            result[rIdx++] = intervals[iIdx++]; 
        
        /** Insert new interval at end **/
        if(iIdx == intervals.length) {
            result[rIdx++] = newInterval;
            return result;
        }

        /** Create updated interval range **/
        int[] interval = new int[2];
        // Save the start of the updated interval range
        interval[0] = Math.min(intervals[iIdx][0], newInterval[0]);
        // Find the end of the new interval
        while(iIdx < intervals.length && intervals[iIdx][0] <= newInterval[1])
            iIdx++;
        iIdx--;

        /** Insert new interval at the beginning **/
        if(iIdx == -1) {
            result[rIdx++] = newInterval;
            for(int i = 0; i < intervals.length; i++)
                result[rIdx++] = intervals[i];
            return result;
        }

        /** Save the updated interval range **/
        // Save the end of the updated interval range
        interval[1] = Math.max(intervals[iIdx][1], newInterval[1]);
        // Save the updated interval range to result
        result[rIdx++] = interval;
        
        /** Save the remaining intervals **/
        while(++iIdx < intervals.length)
            result[rIdx++] = intervals[iIdx];

        // Return the result
        return Arrays.copyOf(result, rIdx);
    }
}
