/*
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 * Note:
 *      A word is defined as a character sequence consisting of non-space characters only.
 *      Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 *      The input array words contains at least one word.
 * Constraints:
 *      1 <= words.length <= 300
 *      1 <= words[i].length <= 20
 *      words[i] consists of only English letters and symbols.
 *      1 <= maxWidth <= 100
 *      words[i].length <= maxWidth
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strs = new ArrayList<>();
        List<String> line = null;
        // Traverse through words array
        for(int i = 0; i < words.length;) {
            int length = 0;
            // Store line in an array
            line = new ArrayList<>();
            // While next word (with spaces) fits in the line - add word to line
            while(i < words.length && words[i].length() + line.size() + length <= maxWidth) {
                length += words[i].length();
                line.add(words[i++]);
            }
            StringBuilder str = new StringBuilder();
            // If only one word or is the last line
            if(line.size() == 1 || i == words.length) {
                str.append(line.get(0));
                for(int j = 1; j < line.size(); j++)
                    str.append(" " + line.get(j));
                while(str.length() < maxWidth) {
                    str.append(" ");
                }
            }
            // If the line has more than one word and is not the last line
            else {
                double remainingSpace = maxWidth - (line.size() - 1 + length);
                for(int j = 0; j < line.size() - 1; j++) {
                    str.append(line.get(j) + " ");
                    int spaces = (int) (remainingSpace / (line.size() - 1 - j) + .99999999);
                    remainingSpace -= spaces;
                    for(int k = 0; k < spaces; k++)
                        str.append(" ");
                }
                str.append(line.get(line.size() - 1));
            } 
            strs.add(str.toString());
        }
        return strs;
    }
}