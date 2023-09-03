// https://projecteuler.net/problem=1
public class MultiplesOf3Or5 {
	
	/*
     * This solution can calculate any two multiples below a given value
     * 
	 * Time Complexity: O(n) where n is the topValue
	 * Space Complexity: O(1)
	 */
	public static void solution1(long topValue, long firstMultiple, long secondMultiple) {
		// Get the sum of the values of the first multiple
		long firstMultipleSum = 0;
		for(long i = firstMultiple; i < topValue; i += firstMultiple) {
			firstMultipleSum += i;
		}
		
		// Get the sum of the values of the second multiple
		long secondMultipleSum = 0;
		for(long i = secondMultiple; i < topValue; i += secondMultiple) {
			secondMultipleSum += i;
		}
		
		// Get the sum of the values of the combined multiples
		long combinedMultiples = firstMultiple * secondMultiple;
		long combinedMultiplesSum = 0;
		for(long i = combinedMultiples; i < topValue; i += combinedMultiples) {
			combinedMultiplesSum += i;
		}
		
		// Calculate the sum
		long sum = firstMultipleSum + secondMultipleSum - combinedMultiplesSum;
		
		// Print the sum
		System.out.println(sum);
	}

	/*
     * This solution can calculate any two multiples below a given value
     * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 */
	public static void solution2(long topValue, long firstMultiple, long secondMultiple) {
		// We will be using the math formula "Sum of an arithmetic series" to help solve this problem.
			// (n / 2) * (2a + (n - 1) * d)
			// n represents the number of terms to be added
			// a is the first term in the sequence
			// d is the constant value between terms
		
		long combinedMultiple = (firstMultiple * secondMultiple);
		
		// we want the numbers below the topValue
		long maxValue = topValue - 1;
		// Get the n value for the formula
		double firstN = maxValue / firstMultiple;
		double secondN = maxValue / secondMultiple;
		double combinedN = maxValue / (firstMultiple * secondMultiple);
		
		// Calculate arithmetic series
		double firstSeries = sumOfArithmeticSeries(firstN, firstMultiple, firstMultiple);
		double secondSeries = sumOfArithmeticSeries(secondN, secondMultiple, secondMultiple);
		double combinedSeries = sumOfArithmeticSeries(combinedN, combinedMultiple, combinedMultiple);
		
		// Calculate sum
		double sum = firstSeries + secondSeries - combinedSeries;
		
		// Print the sum
		System.out.println(
				String.format("%.0f", sum)
				);
	}
	
	// Helper method for calculating the sum of an arithmetic series
	private static double sumOfArithmeticSeries(double n, double a, double d) {
		return (n / 2.0) * (2.0 * a + (n - 1) * d);
	}

}
