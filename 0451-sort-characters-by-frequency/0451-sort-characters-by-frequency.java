class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        StringBuilder[] buckets = new StringBuilder[s.length() + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }

        for (int i = 0; i < 128; i++) {
            int f = freq[i];
            if (f > 0) {
                buckets[f].append((char) i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            for (char c : buckets[i].toString().toCharArray()) {
                result.append(String.valueOf(c).repeat(i));
            }
        }

        return result.toString();
    }
}
