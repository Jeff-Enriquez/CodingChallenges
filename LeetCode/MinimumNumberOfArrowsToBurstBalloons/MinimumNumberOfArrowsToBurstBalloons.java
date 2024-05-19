import java.util.*;
/*
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * 
 * Constraints:
 *      1 <= points.length <= 10^5
 *      points[i].length == 2
 *      -2^31 <= xstart < xend <= 2^31 - 1
 * 
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        /** Sort the points by start of intervals **/
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        /** Count the overlaps **/
        int count = 0;
        for(int i = 0; i < points.length;) {
            count++;
            // Set overlap to greatest range of interval
            int minOverlap = points[i][0];
            int maxOverlap = points[i++][1];
            // While greatest value of next interval is greater than min overlap
            // and smallest value of next interval is smaller than max overlap
            while(i < points.length && points[i][1] >= minOverlap 
            && points[i][0] <= maxOverlap) {
                minOverlap = Math.max(minOverlap, points[i][0]);
                maxOverlap = Math.min(maxOverlap, points[i][1]);
                i++;
            }
        }
        // return the overlaps
        return count;
    }
}
