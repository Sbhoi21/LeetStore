class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int sum = 0, n = cardPoints.length;
        for (int i = 0; i < k && i < n; i++) {
            sum += cardPoints[i];
        }
        if (k >= n) return sum;
        int maxSum = sum;
        while (k != 0) {
            sum += (cardPoints[n-1] - cardPoints[k-1]);
            maxSum = Math.max(maxSum, sum);
            k--; n--;
        }
        return maxSum;
    }
}