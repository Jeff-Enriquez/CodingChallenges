/*
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 * 
 * Constraints:
 *      n == grid.length == grid[i].length
 *      1 <= n <= 200
 *      1 <= grid[i][j] <= 10^5
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
import java.util.*;
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int totalPairs = 0;
        Map<List<Integer>, Integer> rows = new HashMap<>();
        for(int[] row : grid) {
            List<Integer> r = Arrays.stream(row).boxed().toList();
            rows.put(r, rows.getOrDefault(r,0)+1);
        }
        for(int i = 0; i < grid.length; i++) {
            List<Integer> column = new ArrayList<>();
            for(int[] row : grid)
                column.add(row[i]);
            Integer count = rows.get(column);
            if(count != null)
                totalPairs += count;
        }
        return totalPairs;
    }
}
