import java.util.*;
import java.util.stream.Collectors;
// https://www.hackerrank.com/challenges/bomber-man/problem
public class Bomberman {
    /*
	 * Time Complexity: O(x) where x = the grid size * string length
	 * Space Complexity: O(m) where m = the size of the grid
	 */
	public static List<String> bomberMan(int n, List<String> grid) {
		// Return the original grid
		if(n == 1)
			return grid;

		// Return a grid of all 'O'
		if(n % 2 == 0)
			return grid.stream()
					.map(str -> str.replaceAll(".", "O"))
					.collect(Collectors.toCollection(ArrayList::new));

		// The grid only needs to be flipped 2 or 3 times.
		// All flips after that are a repeat of flip 2 and 3.
		int numOfTimesFlipped = (n - 1) / 2;
		if(numOfTimesFlipped > 3) {
			if(numOfTimesFlipped % 2 == 0)
				numOfTimesFlipped = 2;
			else 
				numOfTimesFlipped = 3;
		}
		
		List<String> flippedGrid = new ArrayList<>(grid);
		// Flip the grid
		for(int i = 0; i < numOfTimesFlipped; i++) {
			// Flip '.' to 'x'
			flippedGrid = flippedGrid.stream()
				.map(str -> str.replaceAll("\\.", "x"))
				.collect(Collectors.toCollection(ArrayList::new));
			System.out.println(flippedGrid);
			// Detonate the O's
			for(int k = 0; k < flippedGrid.size(); k++) {
				StringBuilder detonateOs = new StringBuilder(flippedGrid.get(k));
				char[] gridChars = flippedGrid.get(k).toCharArray();
				for(int j = 0; j < gridChars.length; j++) {
					char gridChar = gridChars[j];
					if(gridChar == 'x' || gridChar == '.')
						continue;
					// detonate current O
					detonateOs.replace(j, j+1, ".");
					// detonate to the left of O
					if(j != 0)
						detonateOs.replace(j - 1, j, ".");
					// detonate to the right of O
					if(j != gridChars.length - 1 && gridChars[j+1] != 'O')
						detonateOs.replace(j + 1, j + 2, ".");
					// detonate above the O
					if(k != 0) {
						String s = flippedGrid.get(k - 1);
						if(j == 0)
							s = "." + s.substring(1);
						else if(j == s.length() - 1)
							s = s.substring(0, s.length() - 1) + ".";
						else
							s = s.substring(0, j) + "." + s.substring(j + 1);
						flippedGrid.set(k - 1, s);
					}
					// detonate below the O
					if(k != flippedGrid.size() - 1 && flippedGrid.get(k + 1).charAt(j) != 'O') {
						String s = flippedGrid.get(k + 1);
						if(j == 0)
							s = "." + s.substring(1);
						else if(j == s.length() - 1)
							s = s.substring(0, s.length() - 1) + ".";
						else
							s = s.substring(0, j) + "." + s.substring(j + 1);
						flippedGrid.set(k + 1, s);
					}
					flippedGrid.set(k, detonateOs.toString());
				}
			}
			
			// Flip 'x' to 'O'
			flippedGrid = flippedGrid.stream()
				.map(str -> str.replaceAll("x", "O"))
				.collect(Collectors.toCollection(ArrayList::new));
		}
		
		return flippedGrid;
    }
}
