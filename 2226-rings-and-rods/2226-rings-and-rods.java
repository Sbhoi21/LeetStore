class Solution {
    public int countPoints(String rings) {
         int[][] rods = new int[10][3]; // 10 rods, each with 3 colors (R, G, B)

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rodIndex = rings.charAt(i + 1) - '0';

            if (color == 'R') {
                rods[rodIndex][0] = 1;
            } else if (color == 'G') {
                rods[rodIndex][1] = 1;
            } else if (color == 'B') {
                rods[rodIndex][2] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (rods[i][0] == 1 && rods[i][1] == 1 && rods[i][2] == 1) {
                count++;
            }
        }

        return count;
    }
}