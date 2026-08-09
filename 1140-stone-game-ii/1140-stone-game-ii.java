class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int suffixStones[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixStones[i] = piles[i] + suffixStones[i + 1];
        }

        int dp[][] = new int[n][n + 1];
        return solve(0, 1, piles, suffixStones, dp);

    }

    static int solve(int i, int m, int[] piles, int[] suffixStones, int[][] dp) {
        int n = piles.length;

        if (i > n) {
            return 0;
        }

        if (i+2*m >= n) {
            return suffixStones[i];
        }

        if (dp[i][m] > 0) {
            return dp[i][m];
        }
        int maxStones = 0;

        for (int x=1; x <= 2*m; x++) {

            int opponent = solve(i+x, Math.max(m, x), piles, suffixStones, dp);

            int current = suffixStones[i] - opponent;

            maxStones = Math.max(maxStones, current);

        }

        dp[i][m] = maxStones;
        return maxStones;
    }

}