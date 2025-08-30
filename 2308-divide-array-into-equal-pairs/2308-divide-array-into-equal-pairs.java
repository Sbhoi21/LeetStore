class Solution {
    public boolean divideArray(int[] arr) {
              int n = arr.length;
        if (n % 2 != 0) {
            return false;
        }

        java.util.HashMap<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int freq : frequencyMap.values()) {
            if (freq % 2 != 0) {
                return false;
            }
        }

        return true;
}}