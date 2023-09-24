import java.util.*;
// https://www.hackerrank.com/challenges/one-month-preparation-kit-the-birthday-bar/problem
public class SubarrayDivision1 {
    /*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
    public static int solution(List<Integer> s, int d, int m) {
		// If the segment size (m) is greater than the number of segments (s.size()) 
			// then it is impossible to split the chocolate bar
		if(m > s.size())
            return 0;
		
		// Store the counts
        int countOfSegments = 0;
        // Track the sum of segments
        int sumOfCurrentSegment = 0;
        
        // Get the first segment
        for(int i = 0; i < m; i++){
            sumOfCurrentSegment += s.get(i);
        }
        // Check if the first segment is equal to d
        if(sumOfCurrentSegment == d)
        	countOfSegments++;
        
        // Get the rest of the segments
        for(int i = m; i < s.size(); i++){
            sumOfCurrentSegment -= s.get(i - m);
            sumOfCurrentSegment += s.get(i);
            if(sumOfCurrentSegment == d)
            	countOfSegments++;
        }
        
        return countOfSegments;
	}
}
