import java.util.*;
import java.util.stream.Collectors;
// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class ClimbingTheLeaderboard {
	
	/*
	 * Time Complexity: O(r + p)
	 * Space Complexity: O(r + p)
	 * 		r = ranked.size()
	 * 		p = player.size()
	 */
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		// Remove all duplicates from the ranked list
		List<Integer> ranks = ranked.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
		// Keep track of player ranking
		List<Integer> rankings = new ArrayList<>();
		// Index for player score
		int pIdx = 0;
		Integer score = player.get(pIdx);
		// Iterate through every rank starting from the end
		for(int rIdx = ranks.size() - 1; rIdx >= 0; rIdx--) {
			Integer rank = ranks.get(rIdx);
			// Add to the player rankings
			while(score <= rank) {
				// Same rank
				if(score.equals(rank)) {
					rankings.add(rIdx + 1);
				// Rank after the current 'rank'
				} else {
					rankings.add(rIdx + 2);
				}
				// Get the next player score
				if(++pIdx < player.size())
					score = player.get(pIdx);
				else
					break;
			}
			// All scores have been added to ranking
			if(pIdx == player.size()) {
				break;
			}
		}
		// Any scores that have not yet been added are rank 1.
		for(; pIdx < player.size(); pIdx++)
			rankings.add(1);
		return rankings;
    }
	
}
