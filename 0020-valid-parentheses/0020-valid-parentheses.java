class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {

            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else {
                if (stack.size() == 0 || stack.peek() != c) {
                    return false;
                } else stack.pop();
            }
        }
        if (stack.size() > 0)
            return false;
        return true;

    }
}