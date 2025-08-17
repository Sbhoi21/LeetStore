class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] decoded = new int[n];
        decoded[0] = first;

        for (int i = 1; i < n; i++) {
            decoded[i] = decoded[i - 1] ^ encoded[i - 1];
        }

        return decoded;
    }
}