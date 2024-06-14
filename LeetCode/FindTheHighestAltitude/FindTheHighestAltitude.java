/*
 * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
 *  You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 * 
 * Constraints:
 *      n == gain.length
 *      1 <= n <= 100
 *      -100 <= gain[i] <= 100
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int currAltitude = 0;
        for(int i = 0; i < gain.length; i++) {
            currAltitude += gain[i];
            if(currAltitude > highestAltitude)
                highestAltitude = currAltitude;
        }
        return highestAltitude;
    }
}
