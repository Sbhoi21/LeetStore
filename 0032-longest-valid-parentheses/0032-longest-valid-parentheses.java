class Solution {
    public int longestValidParentheses(String s) {

        // Stack<Integer> stack = new Stack<>();
        // stack.push(-1);

        // int max = 0;

        // for (int i = 0; i < s.length(); i++) {

        //     if (s.charAt(i) == '(') {
        //         stack.push(i);

        //     } else {
        //         stack.pop();

        //         if (stack.isEmpty()) {
        //             stack.push(i);
        //         } else {
        //             max = Math.max(max, i - stack.peek());
        //         }
        //     }
        // }

        // return max;



        int n = s.length();

        int[] stack = new int[n + 1];
        int top = 0;

        stack[0] = -1;

        int max = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {

                stack[++top] = i;

            } else {

                top--;

                if (top < 0) {
                    top = 0;
                    stack[top] = i;
                } else {
                    max = Math.max(max, i - stack[top]);
                }
            }
        }

        return max;


    }
}