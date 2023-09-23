// https://projecteuler.net/problem=2
public class EvenFibonacciNumbers {

	/*
	 * Time Complexity: Binet Formula - the number of fibonacci terms given n
	 * 						-> O((((1 + √5) / 2)^n - ((1 - √5) / 2)^n) / √5)
	 * 						https://www.youtube.com/watch?v=YXIgwwYu1p0&ab_channel=Zak%27sLab
	 * Space Complexity: O(1)
	 */
	public static long solution(long x) {
		// The sum that will be returned
		long sum = 0;
		
		// The current number in the fibonacci sequence
		long currFibNum = 1;
		
		// The previous number in the fibonacci sequence. Used to help calculate the next number in the sequence
		long prevFibNum = 1;
		
		// Loop through all numbers in the Fibonacci sequence - up to and including x.
		while(currFibNum < x) {
			// If the number is even, add to the sum
			if(currFibNum % 2 == 0)
				sum += currFibNum;
			// Get the next sequence numbers 
			long nextSequenceNum = currFibNum + prevFibNum;
			prevFibNum = currFibNum;
			currFibNum = nextSequenceNum;
		}
		return sum;
	}
    
}
