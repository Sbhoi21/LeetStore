import java.util.HashMap;
import java.util.Map;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        // We use Long for the count to prevent overflow during pair calculation
        Map<Double, Long> ratioCount = new HashMap<>();
        long totalPairs = 0;

        for (int[] rect : rectangles) {
            double width = rect[0];
            double height = rect[1];
            double ratio = width / height;

            // Update the frequency of this specific ratio
            ratioCount.put(ratio, ratioCount.getOrDefault(ratio, 0L) + 1);
        }

        // For each group of rectangles with the same ratio, calculate pairs
        for (long count : ratioCount.values()) {
            if (count > 1) {
                // Formula for choosing 2 from k: k * (k-1) / 2
                totalPairs += (count * (count - 1)) / 2;
            }
        }

        return totalPairs;
    }
}