class Solution {
    public int countKDifference(int[] nums, int k) {
               HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            // Check for the complement that would give the required difference
            if (map.containsKey(num - k)) {
                count += map.get(num - k);
            }
            if (map.containsKey(num + k)) {
                count += map.get(num + k);
            }

            // Update the frequency of the current number
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}