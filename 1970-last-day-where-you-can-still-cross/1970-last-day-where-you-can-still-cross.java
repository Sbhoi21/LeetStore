import java.util.*;

class Solution {
    int ROWS, COLS;
    int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        ROWS = row;
        COLS = col;

        int left = 1, right = cells.length;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(mid, cells)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int day, int[][] cells) {
        boolean[][] water = new boolean[ROWS][COLS];

        // mark flooded cells
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            water[r][c] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        // start BFS from top row
        for (int c = 0; c < COLS; c++) {
            if (!water[0][c]) {
                q.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == ROWS - 1) return true;

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS
                        && !water[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
