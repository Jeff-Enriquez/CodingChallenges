// https://projecteuler.net/problem=4
public class LargestPalindromeProduct {
    /*
	 * Time Complexity: O(n^2) -- performs much better than O(n^2) because of conditional checks
	 * Space Complexity: O(1)
	 */
	public static long solution(int x) {
        // Stores the result
		long largestPalindrome = 0;
        // maximum product
		long maximum = 0;
		for(long i = 0; i < x; i++) {
			maximum += Math.pow(10, i) * 9;
		}
        // maximum product that is divisible by 11
		long max11 = maximum;
		while(max11 % 11 != 0)
			max11--;
        // minimum product
		long minimum = (long) Math.pow(10, x - 1);

		// Get the product of numbers maximum to minimum
		for(long i = maximum; i >= minimum; i--) {
			
			// Palindromes are divisible by 11. 
			// If i is divisible by 11, then j can begin with 999 and decrement 1 number at a time.
			// If i is not divisible by 11, then j must be in order for the product to be a palindrome.
			long j = maximum;
			long decrement = 1;
			if(i % 11 != 0) {
				j = max11;
				decrement = 11;
			}
			// Check if the product of i and j is a palindrome
			// j >= i prevents duplicate checks.
			while(j >= i) {
				long product = i*j;
                // Do not need to check products that are less than the largest palindrome
				if(product <= largestPalindrome)
					break;
				if(isPalindrome(product))
					largestPalindrome = product;
				j -= decrement;
			}
		}
		return largestPalindrome;
	}
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static boolean isPalindrome(long number) {
		String num = Long.toString(number);
		int size = num.length();
		int index = size / 2 - 1;
		while(index >= 0) {
			char leftChar = num.charAt(index);
			char rightChar = num.charAt(size - index - 1);
			if(leftChar != rightChar)
				return false;
			--index;
		}
		return true;
	}

	
	public static void main(String[] args) {
		System.out.println(solution(3));
	}
}
