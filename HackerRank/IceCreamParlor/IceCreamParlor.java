import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
// https://www.hackerrank.com/challenges/icecream-parlor/problem
public class IceCreamParlor {
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 		n = arr.size()
	 */
	public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
		// List for storing result
		List<Integer> purchase = new ArrayList<>(2);
		// Map the count of every number in "arr"
			// key: number in the "arr"
			// value: number of times a number appears in "arr"
		Map<Integer, Long> allPrices = arr.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// Iterate through every number of "arr"
		for(int i = 0; i < arr.size(); i++) {
			// Get the current price of "arr"
			int price = arr.get(i);
			// Calculate the other price needed for the result
			int otherPrice = m - price;
			// If price and otherPrice is the same and it appears twice in "arr"
			if((price == otherPrice && allPrices.get(price) >= 2) 
					// OR IF price and otherPrice are not the same and otherPrice exists in "arr"
					|| (price != otherPrice && allPrices.containsKey(otherPrice))) {
				// Calculate the index of "price"
				int firstIdx = i + 1;
				// Calculate the index of "otherPrice"
				int nextIdx = arr.subList(firstIdx, arr.size())
						.indexOf(Integer.valueOf(otherPrice))
						+ firstIdx + 1;
				// Add the indices
				purchase.add(firstIdx);
				purchase.add(nextIdx);
				break;
			}
		}
		// Return the result
		return purchase;
	}
}