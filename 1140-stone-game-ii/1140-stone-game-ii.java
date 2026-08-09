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

        if (i + 2 * m >= n) {
            return suffixStones[i];
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }
        int min = Integer.MAX_VALUE;

        for (int x = 1; x <= 2 * m; x++) {
            int opponent = solve(i + x, Math.max(m, x), piles, suffixStones, dp);
            min = Math.min(min, opponent);
        }
        dp[i][m] = suffixStones[i] - min;
        return dp[i][m];
    }

}