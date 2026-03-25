class Solution {
    public boolean canPartitionGrid(int[][] grid) {

  int m = grid.length;
        int n = grid[0].length;

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        // Check horizontal cuts
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) { // cut after row i
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum * 2 == total) {
                return true;
            }
        }

        // Check vertical cuts
        long[] colPrefix = new long[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colPrefix[j] += grid[i][j];
            }
        }

        long colSum = 0;
        for (int j = 0; j < n - 1; j++) { // cut after col j
            colSum += colPrefix[j];
            if (colSum * 2 == total) {
                return true;
            }
        }

        return false;

        
    }
}