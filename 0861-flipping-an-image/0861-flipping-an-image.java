class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            int left = 0, right = n - 1;
            while (left <= right) {
                // Swap and invert the elements
                if (left == right) {
                    row[left] ^= 1; // Invert the middle element in case of odd length
                } else {
                    int temp = row[left] ^ 1;
                    row[left] = row[right] ^ 1;
                    row[right] = temp;
                }
                left++;
                right--;
            }
        }
        return image;
    }
}