class Solution {
    public String removeOuterParentheses(String s) {

        int currentDepth = 0;
        StringBuilder s1 = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                if (currentDepth > 1) {
                    s1.append(c);
                }
            } else if (c == ')') {
                if (currentDepth > 1) {
                    s1.append(c);
                }
                currentDepth--;
            }
        }
        return s1.toString();
    }

}