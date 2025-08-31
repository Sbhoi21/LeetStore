class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int r = 0, c = col - 1;

        while (r < row && c >= 0) {
            if (grid[r][c] < 0) {
                count += (row - r); // All elements below are negative
                c--; // Move left
            } else {
                r++; // Move down
            }
        }
        return count;
        
    }
}