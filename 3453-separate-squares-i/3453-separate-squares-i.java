class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // Determine search range
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        // Binary search
        for (int i = 0; i < 60; i++) { // enough for 1e-6 precision
            double mid = (low + high) / 2;
            double[] area = computeAreas(squares, mid);

            if (area[0] < area[1]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // returns [below, above]
    private double[] computeAreas(int[][] squares, double H) {
        double below = 0, above = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;
            double area = l * l;

            if (H <= y) {
                above += area;
            } else if (H >= top) {
                below += area;
            } else {
                below += (H - y) * l;
                above += (top - H) * l;
            }
        }
        return new double[]{below, above};
    }
}
