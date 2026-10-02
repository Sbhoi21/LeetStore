class Solution {
    public boolean halvesAreAlike(String s) {

        char[] arr = s.toCharArray();
        // Set<Character> ch = new Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' );
        String ch = "aeiouAEIOU";
        int c = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (ch.indexOf(arr[i]) > -1) {
                c++;
            }
            if (ch.indexOf(arr[i + arr.length / 2]) > -1) {
                c--;
            }
        }
        if (c == 0)
            return true;
        return false;
    }
}