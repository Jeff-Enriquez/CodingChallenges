public class EvenFibonacciNumbers {

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static long solution(long x) {
		// The sum that will be returned
		long sum = 0;
		
		// The current number in the fibonacci sequence
		long currSequenceNum = 1;
		
		// The previous number in the fibonacci sequence. Used to help calculate the next number in the sequence
		long prevSequenceNum = 1;
		
		// Loop through all numbers in the Fibonacci sequence - up to and including x.
		while(currSequenceNum < x) {
			// If the number is even, add to the sum
			if(currSequenceNum % 2 == 0)
				sum += currSequenceNum;
			// Get the next sequence numbers 
			long nextSequenceNum = currSequenceNum + prevSequenceNum;
			prevSequenceNum = currSequenceNum;
			currSequenceNum = nextSequenceNum;
		}
		return sum;
	}
    
}
