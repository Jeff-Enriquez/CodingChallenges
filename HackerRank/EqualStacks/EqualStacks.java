import java.util.*;
// https://www.hackerrank.com/challenges/equal-stacks/problem
public class EqualStacks {
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 		n = the size of the lists
	 */
	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        long h1Height = h1.stream().reduce(0, Integer::sum);
        int h1Idx = 0;
        long h2Height = h2.stream().reduce(0, Integer::sum);
        int h2Idx = 0;
        long h3Height = h3.stream().reduce(0, Integer::sum);
        int h3Idx = 0;
        
        while(!(h1Height == h2Height && h1Height == h3Height)) {
        	if(h1Idx < h1.size() && (h1Height > h2Height || h1Height > h3Height))
        		h1Height -= h1.get(h1Idx++);
        	if(h2Idx < h2.size() && (h2Height > h1Height || h2Height > h3Height))
        		h2Height -= h2.get(h2Idx++);
        	if(h3Idx < h3.size() && (h3Height > h1Height || h3Height > h2Height))
        		h3Height -= h3.get(h3Idx++);
        }
        
        return (int) h1Height;
    }
	
}
