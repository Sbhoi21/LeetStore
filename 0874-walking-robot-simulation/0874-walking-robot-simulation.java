
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(hash(o[0], o[1]));
        }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0, x = 0, y = 0, ans = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if (set.contains(hash(nx, ny))) break;
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }

        return ans;
    }

    private long hash(int x, int y) {
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }
}