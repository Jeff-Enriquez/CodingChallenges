import java.util.*;
/*
 * https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(int i = 1; i < path.length(); i++) {
            int startIdx = i;
            while(i < path.length() && path.charAt(i) != '/')
                i++;
            String nextPath = path.substring(startIdx, i);
            if("..".equals(nextPath)) {
                if(deque.size() > 0)
                    deque.removeFirst();
            }
            else if(nextPath.length() > 0 && !".".equals(nextPath)) {
                deque.addFirst(nextPath);
            }
        }
        StringBuilder str = new StringBuilder("/");
        while(deque.size() > 1) {
            str.append(deque.removeLast() + "/");
        }
        if(deque.size() > 0)
            str.append(deque.removeLast());
        return str.toString();
    }
}
