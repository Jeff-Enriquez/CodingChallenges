import java.util.*;

public class SmallestMultiple {
	
	/*
	 * Time Complexity: O(n * sqrt(n))
	 * Space Complexity: O(log(log(n)))
	 */
	public static long listingMultiples(long... nums) {
		long smallestMultiple = nums[0];
		for(int i = 1; i < nums.length; i++) {
			long num = nums[i];
			// Identify the greatest common factor of the two numbers
			long gcf = gcf(smallestMultiple, num);
			// Update the smallest multiple
			smallestMultiple = (smallestMultiple * num) / gcf;
		}
		return smallestMultiple;
	}
	
	/*
	 * log(log(n)) is the average number of factors of a given number
	 * 
	 * Time Complexity: O(sqrt(num1) + sqrt(num2))
	 * Space Complexity: O(log(log(num1)) + log(log(num2)))
	 */
	public static long gcf(long num1, long num2) {
		if(num1 < 1 || num2 < 1) {
			throw new IllegalArgumentException("The arguments must be greater or equal to '1'.");
		}
		int sqrt1 = (int) Math.sqrt(num1);
		int sqrt2 = (int) Math.sqrt(num2);
		
		// Store the count of factors from greatest to least
		Map<Long, Integer> countOfFactors = new TreeMap<Long, Integer>(Collections.reverseOrder());
		
		// Store the factors of num1
		for(long i = sqrt1; i >= 1; i--) {
			if(num1 % i != 0)
				continue;
			countOfFactors.put(
					i,
					countOfFactors.getOrDefault(i, 0) + 1
				);
			countOfFactors.put(
					num1/i,
					countOfFactors.getOrDefault(num1/i, 0) + 1
				);
		}
		
		// Store the factors of num2
		for(long i = sqrt2; i >= 1; i--) {
			if(num2 % i != 0)
				continue;
			countOfFactors.put(
					i,
					countOfFactors.getOrDefault(i, 0) + 1
				);
			countOfFactors.put(
					num2/i,
					countOfFactors.getOrDefault(num2/i, 0) + 1
				);
		}
		
		// Find the greatest common factor
		for(Map.Entry<Long,Integer> element : countOfFactors.entrySet()) {
			if(element.getValue() > 1) // if the count is greater than 1, then the factor exists in both num1 and num2
				return element.getKey();
		}
		throw new RuntimeException("Failed to get greatest common factor.");
	}
	
	/* 
	 * (n / log(n)) prime counting function - number of or primes less than or equal to n.
	 * 
	 * Time Complexity: O(n * (n / log(n))
	 * Space Complexity: O(n / log(n))
	 */
	public static long primeFactorization(long... nums) {
		long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		long[] factor = new long[primes.length];
		
		// Save the max num of the given nums
		long maxN = Long.MIN_VALUE;
		
		// Calculate the prime factors of every given num
		for(int i = 0; i < nums.length; i++) {
			long n = nums[i]; // the current num
			
			
			if(n > maxN)
				maxN = n; // the max num
			
			// Calculate all prime factors of the given number
			double logN = Math.log(n); // used for calculating the exponent of the prime number
			for(int j = 0; primes[j] <= n; j++) {
				double logP = Math.log(primes[j]); // used for calculating the exponent of the prime number
				// Formula for calculating the exponent of the prime number
				long f = (long) Math.floor(logN / logP);
				// Save the largest exponent of the prime number
				factor[j] = Math.max(f, factor[j]);
			}
		}
		
		// Calculate the lowest common denominator
		long leastCommonMultiple = 1;
		for(int i = 0; primes[i] <= maxN; i++) {
			leastCommonMultiple *= Math.pow(primes[i], factor[i]);
		}
		return leastCommonMultiple;
	}
	
	public static void main(String[] args) {
		long[] nums = new long[20];
		for(int i = 1; i <= 20; i++)
			nums[i-1] = i;
		System.out.println(listingMultiples(nums)); // Expected result: 232792560
	}
}
