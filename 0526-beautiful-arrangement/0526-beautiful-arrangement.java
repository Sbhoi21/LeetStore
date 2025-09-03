class Solution {


    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return countArrangementHelper(n, 1, visited);
    }

    private static int countArrangementHelper(int n, int position, boolean[] visited) {
        if (position > n) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % position == 0 || position % i == 0)) {
                visited[i] = true;
                count += countArrangementHelper(n, position + 1, visited);
                visited[i] = false;
            }
        }
        return count;
    }
}