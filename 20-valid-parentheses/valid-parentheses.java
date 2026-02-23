import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                // If stack is empty or top is not matching, invalid
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        // Valid if stack is empty at the end
        return stack.isEmpty();
    }
}