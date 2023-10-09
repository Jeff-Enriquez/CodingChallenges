// https://projecteuler.net/problem=7
public class Prime1001st {
	
	/*
	 * Time Complexity: O(x * sqrt(x))
	 * Space Complexity: O(1)
	 */
	public static long solution(long x) {
		long countOfPrimes = 0;
		long currentNum = 1;
		
		while(countOfPrimes < x) {
			currentNum++;
			if(isPrime(currentNum))
				countOfPrimes++;
		}
		return currentNum;
	}
	
	/*
	 * Time Complexity: O(sqrt(x))
	 * Space Complexity: O(1)
	 */
	public static boolean isPrime(long x) {
		// Only need to check up to sqrt(x)
		long sqrtX = (long) Math.sqrt(x);
		for(long currentNum = 2; currentNum <= sqrtX; currentNum++) { // O(sqrt(x))
			// If it divides evenly then it is not prime
			if(x % currentNum == 0) 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(10001));
	}
}
