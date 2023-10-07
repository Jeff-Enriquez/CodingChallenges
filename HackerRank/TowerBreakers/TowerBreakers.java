// https://www.hackerrank.com/challenges/tower-breakers-1/problem
public class TowerBreakers {

    /*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int towerBreakers(int n, int m) {
        // If there are an even number of towers, player 2 wins
        // If the height of all the towers is 1, player 2 wins
        if(n % 2 == 0 || m == 1)
            return 2;
        return 1;
    }

}
