import java.util.*;
/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Constraints:
 *      1 <= intervals.length <= 10^4
 *      intervals[i].length == 2
 *      0 <= starti <= endi <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // The intervals can range from 0 to 10,000
        // Double the size. The spaces between each number determine if there is overlap.
        boolean[] allIntervals = new boolean[20_002];
        /** Save the intervals to allIntervals **/
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0] * 2;
            int end = intervals[i][1] * 2;
            while(start <= end) {
                allIntervals[start] = true;
                start++;
            }
        }
        /** Save all interval ranges to list **/
        List<List<Integer>> list = new ArrayList<>();
        int length = allIntervals.length;
        for(int i = 0; i < length; i++) {
            // Get the first number of the range
            while(i < length && !allIntervals[i]) i++;
            if(i == length)
                break;
            int start = i / 2;
            // Get the last number of the range
            while(i < length && allIntervals[i]) i++;
            int end = (i - 1) / 2;
            list.add(List.of(start, end));
        }
        /** Convert list to array **/
        int rows = list.size();
        int cols = list.get(0).size();
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = list.get(i).get(j);
            }
        }

        return array;
    }
}
