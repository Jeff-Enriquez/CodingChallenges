// https://www.hackerrank.com/challenges/counter-game/problem
public class CounterGame {
    /*
	 * Time Complexity: O(log(n))
	 * Space Complexity: O(1)
	 */
	public static String counterGame(long n) {
		int turn = 1;
		String[] players = new String[] {"Louise", "Richard"};
		
		// Richard wins
		if(n < 2)
			return players[turn];
		
		while(n >= 2) {
			// Change player turn
			turn = turn == 0 ? 1 : 0;
			
			// Calculate the greatest power of 2 that is less than or equal to n. Formula: 2^log2(n)
				// There is no log2(n) in java. The equivalent is (logE(n) / logE(2))
			long greatestPower = (long)(Math.log(n)/Math.log(2));
			long num = (long) Math.pow(2, greatestPower);
			
			// 'num' is a power of 2 and if 'n' is a power of 2 then we can calculate who will win
			if(n == num)
				if(greatestPower % 2 == 0)
					return players[turn == 0 ? 1 : 0];
				else
					return players[turn];
			// Get the next n
			n -= num;
		}
		
		// Player reduced n to 1
		return players[turn];
	}
}
