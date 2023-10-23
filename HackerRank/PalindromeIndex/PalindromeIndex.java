// https://www.hackerrank.com/challenges/palindrome-index/problem
public class PalindromeIndex {
	/* 
	 * Time Complexity: O(n) where n = s.length()
	 * Space Complexity: O(1)
	 */
	public static int palindromeIndex(String s) {
		int solutionIdx = -1;
        int lToRIdx = 0;
        int rToLIdx = s.length() - 1;
        // Iterate through every character starting from the ends to the center
        while(lToRIdx < rToLIdx){
            Character leftChar = s.charAt(lToRIdx);
            Character rightChar = s.charAt(rToLIdx);
            // When the characters don't match, determine which should be removed
            if(leftChar != rightChar) {
                if(s.charAt(lToRIdx + 1) == rightChar 
                		&& s.charAt(lToRIdx + 2) == s.charAt(rToLIdx - 1)) {
                    solutionIdx = lToRIdx;
                    lToRIdx++;
                } else if(s.charAt(rToLIdx - 1) == leftChar
                		&& s.charAt(rToLIdx - 2) == s.charAt(lToRIdx + 1)) {
                    solutionIdx = rToLIdx;
                    rToLIdx--;
                } else
                    return -1;
                rToLIdx--;
                lToRIdx++;
            }
            lToRIdx++;
            rToLIdx--;
        }
        // When only the middle character needs to be removed. Ex: "aba"
        if(s.length() % 2 != 0 && solutionIdx == -1)
            solutionIdx = s.length() / 2;
        return solutionIdx;
    }
	
	public static void main(String[] args) {
		System.out.println(palindromeIndex("acwnnwcwa")); // Expected Result: 7
	}
}
