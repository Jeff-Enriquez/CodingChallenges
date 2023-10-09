// https://www.hackerrank.com/challenges/recursive-digit-sum/problem
public class RecursiveDigitSum {
    /*
	 * x = the number representation of String n
	 * n = the length of the string
	 * k = the value of k
	 * 
	 * Time Complexity: O(n * log10(x * k))
	 * Space Complexity: O(log10(x * k))
	 */
	public static int superDigit(String n, int k) {
		long superX = 0;
		for(int i = 0; i < n.length(); i++) {
			String s = String.valueOf(n.charAt(i));
			long num = Long.valueOf(s);
			superX += num;
		}
		superX *= k;
		if(superX > 9)
			superX = superDigit(String.valueOf(superX), 1);
		return (int) superX;
	}
}
