class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(ans);
                ans = new StringBuilder();
            } else if (c == ')') {
                ans.reverse();
                StringBuilder temp = stack.pop();

                temp.append(ans);
                ans = temp;
            } else {
                ans.append(c);
            }

        }
        return ans.toString();
    }
}