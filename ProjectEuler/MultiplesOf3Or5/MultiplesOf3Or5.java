/*
 * Based on the example: "multiples of 3 and 5 below 1000 equals 233168" we know that shared multiples, such as 15, are only counted once.
 * This means we need to calculate the following:
 * 		- all the multiples of 3
 * 		- all the multiples of 5
 * 		- all the multiples of (3 * 5)
 * Then we add the multiples of 3, plus the multiples of 5, and subtract the multiples of (3 * 5).
 * 		The reason we subtract the multiples of (3 * 5) is because they are counted twice. Once by multiples of 3 and again by multiples of 5. We only want the multiple one time, not two.
 */
// https://projecteuler.net/problem=1
public class MultiplesOf3Or5 {
	
	/*
	 * Solution with for loops
	 * 
	 * Time Complexity: O((x / m1) + (x / m2) + (x / (m1 * m3)))
	 * 						-> we can remove (x / (m1 * m3)) since it will always be less than (x / m1) or (x / m2) 
	 * 						-> O((x / m1) + (x / m2)) 
	 * Space Complexity: O(1)
	 * 
	 * @param x 	the value of which we calculate the multiples.
	 * 					constraint: 1 <= x <= 10^9
	 * @param m1 	the first multiple we sum below x.
	 * 					constraint: 1 <= m1 <= x
	 * @param m2	the second multiple we sum below x.
	 * 					constraint: 1 <= m2 <= x
	 * @return 		the sum of multiples m1 and m2 below x.
	 */
	public static void solution1(long x, long m1, long m2) {
		// Get the sum of the values of the first multiple
		long m1Sum = 0;
		for(long i = m1; i < x; i += m1) {
			m1Sum += i;
		}
		
		// Get the sum of the values of the second multiple
		long m2Sum = 0;
		for(long i = m2; i < x; i += m2) {
			m2Sum += i;
		}
		
		// Get the sum of the values of the combined multiples
		long m3 = m1 * m2;
		long m3Sum = 0;
		for(long i = m3; i < x; i += m3) {
			m3Sum += i;
		}
		
		// Calculate the sum of the first and second multiples below "x"
		long sum = m1Sum + m2Sum - m3Sum;
		// Print the sum
		System.out.println(sum);
	}

	/*
	 * Solution with "sum of an arithmetic series"
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(1)
	 * 
	 * @param x 	the value of which we calculate the multiples.
	 * 					constraint: 1 <= x <= 10^9
	 * @param m1 	the first multiple we sum below x.
	 * 					constraint: 1 <= m1 <= x
	 * @param m2	the second multiple we sum below x.
	 * 					constraint: 1 <= m2 <= x
	 * @return 		the sum of multiples m1 and m2 below x.
	 */
	public static void solution2(long x, long m1, long m2) {
		// We will be using the math formula "sum of an arithmetic series" to help solve this problem.
			// (n / 2) * (2a + (n - 1) * d)
			// n represents the number of terms to be added
			// a is the first term in the sequence
			// d is the constant value between terms
		
		// Needed for calculating the sum of the first and second multiples below "x"
		long m3 = (m1 * m2);
		
		// We only want the numbers below the x, not equal to it
		long maxValue = x - 1;
		
		// Get the n value for the formula. We do not want a fraction.
		long nForM1 = maxValue / m1;
		long nForM2 = maxValue / m2;
		long nForM3 = maxValue / m3;
		
		// Calculate the sum of each multiple using the arithmetic series
		long sumOfM1 = sumOfArithmeticSeries(nForM1, m1, m1);
		long sumOfM2 = sumOfArithmeticSeries(nForM2, m2, m2);
		long sumOfM3 = sumOfArithmeticSeries(nForM3, m3, m3);
		
		// Calculate the sum of the first and second multiples below "x"
		long sum = sumOfM1 + sumOfM2 - sumOfM3;
		
		// Print the sum
		System.out.println(sum);
	}
	
	// Helper method for calculating the sum of an arithmetic series
	private static long sumOfArithmeticSeries(double n, double a, double d) {
		return (long) ((n / 2.0) * (2.0 * a + (n - 1) * d));
	}
	
	// For executing sample questions
	public static void main(String[] args) {
		solution1(14, 2, 3);
			// answer = 54
		solution2(1000, 3, 5);
			// answer = 233168
	}
}