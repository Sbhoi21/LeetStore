class Solution {
    public boolean winnerSquareGame(int n) {
        int dp[] = new int[n + 1];
        return solve(n, dp);
    }

    static boolean solve(int i, int[] dp) {
        
        if (isPerfectSqare(i)) {
            return true;
        }

        if (dp[i] == 1) return true;
        if (dp[i] == 2) return false;

        for (int x = 1; x * x <= i; x++) {
            boolean opponent = solve(i - (x * x), dp);
            if (opponent == false) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 2;
        return false;

    }

    static boolean isPerfectSqare(int i) {

        int x = (int) Math.sqrt(i);
        return (x * x == i);
    }
}