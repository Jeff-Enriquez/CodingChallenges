import java.util.*;
/*
 * This problem test your ability to follow detailed coding instructions.
 */
// https://www.hackerrank.com/challenges/dynamic-array/problem
public class DynamicArray {

	/*
	 * Time Complexity: O(q), where q = queries.size()
	 * Space Complexity: O(n)
	 */
	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
            arr.add(new ArrayList<>());
        int lastAnswer = 0;
        List<Integer> answers = new ArrayList<>();
        for(List<Integer> query : queries){
            Integer queryType = query.get(0);
            Integer x = query.get(1);
            Integer y = query.get(2);
            int idx = ((x ^ lastAnswer) % n);
            if(queryType == 1){
                arr.get(idx).add(y);
            } else {
                int idxArrSize = arr.get(idx).size();
                lastAnswer = arr.get(idx).get(y % idxArrSize);
                answers.add(lastAnswer);
            }
        }
        return answers;
    }
	
}
