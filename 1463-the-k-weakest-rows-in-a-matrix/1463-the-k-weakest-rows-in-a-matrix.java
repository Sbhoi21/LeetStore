class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;
        int n = mat[0].length;
        int[] strength = new int[m];

        for (int i = 0; i < m; i++) {
            strength[i] = countSoldiers(mat[i]);
        }

        int[] result = new int[k];
        boolean[] selected = new boolean[m];

        for (int i = 0; i < k; i++) {
            int minStrength = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < m; j++) {
                if (!selected[j] && strength[j] < minStrength) {
                    minStrength = strength[j];
                    index = j;
                }
            }
            result[i] = index;
            selected[index] = true;
        }

        return result;
    }

    static int countSoldiers(int[] row) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}