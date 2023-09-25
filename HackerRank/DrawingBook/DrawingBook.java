// https://www.hackerrank.com/challenges/drawing-book/problem
public class DrawingBook {
    /*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int solution(int n, int p) {
        // The number of flips starting from the front of the book
        int frontToEnd = (p / 2);
        // If the number of pages is even, then the last page has one page number.
        if(n % 2 == 0)
            n++;
        // The number of flips starting from the end of the book
        int endToFront = ((n - p) / 2);
        // Return the smaller flip count
        return frontToEnd < endToFront ? frontToEnd : endToFront;
    }
}
