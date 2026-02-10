class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int sum = 0, n = cardPoints.length;
        for (int i = 0; i < k && i < n; i++) {
            sum += cardPoints[i];
        }
        if (k >= n) return sum;
        int maxSum = sum;
        for (int right = n-1; k != 0; k--,right--) {
            sum += (cardPoints[right] - cardPoints[k-1]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}