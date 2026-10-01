class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {

            if (c == ')') {
                if (stack.size() > 0 && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (c == ']') {
                if (stack.size() > 0 && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else if (c == '}') {
                if (stack.size() > 0 && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else
                stack.push(c);
        }
        if (stack.size() > 0)
            return false;
        return true;

    }
}