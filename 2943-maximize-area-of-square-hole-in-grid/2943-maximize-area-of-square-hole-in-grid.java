
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = getMaxConsecutive(hBars);
        int maxV = getMaxConsecutive(vBars);
        
        int side = Math.min(maxH + 1, maxV + 1);
        
        return side * side;
    }

    private int getMaxConsecutive(int[] bars) {
        Arrays.sort(bars);
        int maxLen = 1;
        int currentLen = 1;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}