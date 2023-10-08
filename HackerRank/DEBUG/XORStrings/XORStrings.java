// Debug Challenge
// https://www.hackerrank.com/challenges/strings-xor/problem
public class XORStrings {
	
	public static String stringsXOR(String s, String t) {
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i)) // change '=' to '=='
                res += "0"; // change '=' to '+='
            else
                res += "1"; // change '=' to '+='
        }

        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(stringsXOR("10101", "00101"));
			// Expected Output: 10000
	}
	
}
