class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        float slope = (coordinates[1][0] - coordinates[0][0]) == 0 ? 15000
                : (float) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        System.out.println(slope);
        for (int i = 2; i < coordinates.length; i++) {
            float tempSlope = (coordinates[i][0] - coordinates[i - 1][0]) == 0 ? 15000
                    : (float) (coordinates[i][1] - coordinates[i - 1][1]) / (coordinates[i][0] - coordinates[i - 1][0]);
            System.out.println("tempSlope:  " + tempSlope);
            if (tempSlope != slope) {
                return false;
            }
        }
        return true;
    }
}