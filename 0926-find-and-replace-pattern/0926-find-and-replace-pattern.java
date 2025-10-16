class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (matches(w, pattern)) res.add(w);
        }
        return res;
    }

    // Check bijection: pattern -> word and word -> pattern
    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) return false;

        // Use two maps (or arrays) to ensure one-to-one mapping
        int[] p2w = new int[26];  // map from pattern char to word char
        int[] w2p = new int[26];  // map from word char to pattern char
        Arrays.fill(p2w, -1);
        Arrays.fill(w2p, -1);

        for (int i = 0; i < word.length(); i++) {
            int pc = pattern.charAt(i) - 'a';
            int wc = word.charAt(i) - 'a';

            if (p2w[pc] == -1 && w2p[wc] == -1) {
                p2w[pc] = wc;      // establish mapping both ways
                w2p[wc] = pc;
            } else {
                // must be consistent in both directions
                if (p2w[pc] != wc || w2p[wc] != pc) return false;
            }
        }
        return true;
    }
}