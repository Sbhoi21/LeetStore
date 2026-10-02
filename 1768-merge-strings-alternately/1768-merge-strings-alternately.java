class Solution {
    public String mergeAlternately(String word1, String word2) {

        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();

        char[] ans = new char[ch1.length + ch2.length];

        int i = 0;
        int l1 = 0, l2 = 0;
        while (i < (Math.min(ch1.length, ch2.length) * 2)) {
            ans[i++] = ch1[l1++];
            ans[i++] = ch2[l2++];
        }
        while (l1 < ch1.length) {
            ans[i++] = ch1[l1++];
        } 
        while (l2 < ch2.length) {
            ans[i++] = ch2[l2++];
        }

        return new String(ans);
    }
}