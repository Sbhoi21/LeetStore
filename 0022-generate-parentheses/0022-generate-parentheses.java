class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        stack(0, 0,  n, "", ans);
        return ans;

    }

    static void stack(int open, int close, int n, String s, List<String> ans) {
        
            if (s.length() == n*2) {
                ans.add(s);
                return;
            }

            if (open < n) {
                stack(open+1, close, n, s + '(', ans);
            }

            if (close < open) {
                stack(open, close+1, n, s + ')', ans);
            }
    } 
}