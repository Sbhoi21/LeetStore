class Solution {
    public boolean isValid(String s) {

        // Stack<Character> stack = new Stack();

        // for (char c : s.toCharArray()) {

        //     if (c == '(')
        //         stack.push(')');
        //     else if (c == '[')
        //         stack.push(']');
        //     else if (c == '{')
        //         stack.push('}');
        //     else {
        //         if (stack.size() == 0 || stack.peek() != c) {
        //             return false;
        //         } else stack.pop();
        //     }
        // }
        // if (stack.size() > 0)
        //     return false;
        // return true;

        char[] st = new char[s.length()];

        int head = 0;

        for (char c : s.toCharArray()) {

            if (c == '(')
                st[head++] = ')';
            else if (c == '[')
                st[head++] = ']';
            else if (c == '{')
                st[head++] = '}';
            else {
                if (head == 0 || st[--head] != c) {
                    return false;
                }
            }
        }
        if (head > 0) return false;
        return true;
    }
}