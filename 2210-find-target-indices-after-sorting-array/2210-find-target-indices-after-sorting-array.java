class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
           java.util.Arrays.sort(arr);
        List<Integer> indices = new java.util.ArrayList<>();
        
        // Find indices of the target element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indices.add(i);
            }
        }
        return indices;

    }
}