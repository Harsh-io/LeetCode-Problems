import java.util.*;

class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // If stack is not empty,
                // this is NOT the outer '('
                if (!stack.isEmpty()) {
                    sb.append(ch);
                }

                stack.push(ch);

            } else {

                // Remove current '(' from stack
                stack.pop();

                // If stack is not empty,
                // this ')' is NOT the outer ')'
                if (!stack.isEmpty()) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}