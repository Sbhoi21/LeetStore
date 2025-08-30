class Solution {
    public boolean divideArray(int[] arr) {
                int n = arr.length;
        if (n % 2 != 0) {
            return false; // If the array length is odd, we cannot form pairs
        }

        int[] frequency = new int[501]; // Assuming the range of numbers is 0 to 500
        for (int num : arr) {
            frequency[num]++;
        }

        for (int freq : frequency) {
            if (freq % 2 != 0) {
                return false; // If any number has an odd frequency, pairs cannot be formed
            }
        }

        return true;
}}