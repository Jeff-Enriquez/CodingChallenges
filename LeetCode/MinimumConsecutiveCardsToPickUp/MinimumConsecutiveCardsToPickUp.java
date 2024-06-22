/*
 * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.
 * Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1. 
 * 
 * Constraints:
 *      1 <= cards.length <= 10^5
 *      0 <= cards[i] <= 10^6
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) - worst case
 */
import java.util.*;
public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        Integer prevIdx = -1;
        for(int i = 0; i < cards.length; i++) {
            prevIdx = map.put(cards[i], i);
            if(prevIdx != null)
                minLen = Math.min(i - prevIdx + 1, minLen);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
