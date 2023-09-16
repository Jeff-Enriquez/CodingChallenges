import java.util.*;

public class LargestPrimeFactor {
	
	/*
	 * Time Complexity: O(x + log(log(x)) * (x/2)) 
	 * 						-> drop the constant -> O(log(log(x)) * x + x) 
	 * 						-> drop the lesser value -> O(x * (log(log(x))))
	 * Space Complexity: O(1)
	 */
	public static long solution1(long x) {
		// Start with the largest number (x) and increment down
		for(long currentNum = x; currentNum > 1; currentNum--) {
			// If currentNum is NOT a factor of x, get the next number
			if(x % currentNum != 0) // Occurs O(x) times
				continue;
			
			// Everything from this point occurs O(log(log(x))), that's the average number of factors in a number
			// Assume the currentNum is prime until proven false
			boolean isPrime = true;
			for(long divisor = 2; divisor < currentNum; divisor++) { // O(x/2)
				// If it divides evenly then it is not prime
				if(currentNum % divisor == 0) {
					isPrime = false;
					break;
				}
			}
			// Since we are starting with the largest number we can end at the first prime number we find.
			if(isPrime)
				return currentNum;
		}
		// x <= 1
		return x;
	}
	
	/*
	 * Time Complexity: O(sqrt(x/2) * log(log(sqrt(x))) + sqrt(x))
	 * 							-> drop the constant -> O(sqrt(x) * log(log(sqrt(x))) + sqrt(x))
	 * 							-> drop the lesser value -> O(sqrt(x))
	 * Space Complexity: O(1)
	 */
	public static long solution2(long x) {
		// Only need to check up to sqrt(x)
		long sqrtX = (long) Math.sqrt(x);
		
		long possiblePrime = x;
		
		// Find the factors of x. 
		// Start with the smallest number (2, because prime numbers are allowed to be 1)
		for(long currentNum = 2; currentNum <= sqrtX; currentNum++) {
			if(x % currentNum != 0) // O(sqrt(x)
				continue;
			
				// Everything inside of the if statement occurs O(log(log(x))), that's the average number of factors in a number
				// Get the larger factor
				long largerFactor = x / currentNum; 
				if(isPrime2(largerFactor))
					return largerFactor;
				else if(isPrime2(currentNum))
					possiblePrime = currentNum;
		}
		return possiblePrime;
	}
	
	/*
	 * Time Complexity: O(sqrt(x))
	 * Space Complexity: O(1)
	 */
	public static boolean isPrime2(long x) {
		// Only need to check up to sqrt(x)
		long sqrtX = (long) Math.sqrt(x);
		for(long currentNum = 2; currentNum <= sqrtX; currentNum++) { // O(sqrt(x))
			// If it divides evenly then it is not prime
			if(x % currentNum == 0) 
				return false;
		}
		return true;
	}
	
	/*
	 * Time Complexity: O(sqrt(x) + log(log(x)) * sqrt(x)/log(sqrt(x)) + sqrt(x) * log(log(sqrt(x)))
	 * 							-> drop the lesser value -> O(sqrt(x))
	 * Space Complexity: O(sqrt(x))
	 */
	public static boolean[] primes;
	public static List<Integer> primeNumbers = new ArrayList<>();
	public static int solution3(long x) {
		long maximumAllowedValue = (Integer.MAX_VALUE - 2L) * (Integer.MAX_VALUE - 2L);
		if(x > maximumAllowedValue)
			return -1;
		
		int sqrtX = (int) Math.sqrt(x);
		instantiatePrimes(sqrtX); // O(sqrt(x) * log(log(sqrt(x)))
		
		int possiblePrime = (int) x;
		for(int currentNum = 2; currentNum <= sqrtX; currentNum++) {
			if(x % currentNum != 0) // O(sqrt(x))
				continue;
			
			// Everything from this point occurs O(log(log(x))), that's the average number of factors in a number
			int largerFactor = (int) x / currentNum; 
			if(isPrime3(largerFactor)) { // O(sqrt(x)/log(sqrt(x)))
				return largerFactor;
			} else if(isPrime3(currentNum)) { // O(sqrt(x)/log(sqrt(x)))
				possiblePrime = currentNum;
			}
		}
		return possiblePrime;
	}
	/* 
	 * Sieve of Eratosthenes https://www.geeksforgeeks.org/sieve-of-eratosthenes/#
	 * The original Sieve of Eratosthenes is O(x*log(log(x)) but we only need the sqrt(x)
	 * 
	 * Time Complexity: O(sqrt(x) * log(log(sqrt(x)))
	 * Space Complexity: O(sqrt(x))
	 */
	private static void instantiatePrimes(int x) {
		primes = new boolean[x];
		for(int i = 0; i < primes.length; i++)
			primes[i] = true;
		
		long index = 2;
		while(index + index < primes.length) {
			for(long i = index + index; i < primes.length; i += index) {
				primes[(int) i] = false;
			}
			// Get next index
			do {
				index++;
			} while(index < primes.length && !primes[(int) index]);
		}
		for(int i = 2; i < primes.length; i++)
			if(primes[i] == true)
				primeNumbers.add(i);
	}
	
	/*
	 * n/log(n) gives us the approximate amount of prime numbers below a given number
	 * 
	 * Time Complexity: O(sqrt(x)/log(sqrt(x)))
	 * Space Complexity: O(1)
	 */
	private static boolean isPrime3(long x) {
		int sqrtX = (int) Math.sqrt(x);
		int i = 0;
		Integer primeNum;
		do {
			primeNum = primeNumbers.get(i++);
			if(x % primeNum == 0)
				return false;
		} while(primeNum <= sqrtX && i < primeNumbers.size());
		return true;
	}
	
	public static void main(String[] args) {
		long x = 600851475143L;
//		System.out.println(solution1(x));
		System.out.println(solution2(33));
		System.out.println(solution3(33));
	}
	
}
/*
 * Trial Division (Basic Method): You divide the number by all integers from 2 to the square root of the number.

Probabilistic Primality Tests: High probability of returning the correct answer but can be incorrect (Miller-Rabin test | Fermat test).
		java.math.BigInteger.isProbablePrime() uses Miller-Rabin
Deterministic Primality Tests: Guaranteed to provide a correct answer (AKS primarlity test
	AKS O((log(n))^6) - The time complexity of the AKS primality test is 𝑂(𝑛^6), where 𝑛 is the length of the input. The length of an integer 𝑁 is roughly log𝑁, so the time complexity of the AKS primality test applied to the integer 𝑁 is O((log(n))^6).
		Space Complexity: O((log n)^2)
		// https://cs.stackexchange.com/questions/75578/why-aks-primality-test-is-called-polynomial#:~:text=The%20time%20complexity%20of%20the,O(log6N).
Elliptic Curve Primality Proving (ECPP): Fastest Deterministic Primality Test - possibly O( N log N/ log log N).
	Also O((log(n))^6) - In practice, it is faster than AKS. Just because two methods have the same Time Complexity, does not mean they take the same amount of time to run. It only demonstrates how the runtime scales as the input get's larger.
		Space Complexity: O((log n)^2)
		// https://www.cs.ou.edu/~qcheng/paper/aksimp.pdf
Mathmaticians are working on improving the Time Complexity of these methods.	
	
Use of Specialized Software: For very large numbers, it's often more practical to use specialized primality testing software or libraries such as GMP (GNU Multiple Precision Arithmetic Library) or specialized computer clusters and distributed computing resources.


Sieve of Eratosthenes

 */