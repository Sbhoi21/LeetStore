class Solution {
    public boolean halvesAreAlike(String s) {

        // char[] arr = s.toCharArray();
        // // Set<Character> ch = new Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' );
        // String ch = "aeiouAEIOU";
        // int c = 0;
        // for (int i = 0; i < arr.length / 2; i++) {
        //     if (ch.indexOf(arr[i]) > -1) {
        //         c++;
        //     }
        //     if (ch.indexOf(arr[i + arr.length / 2]) > -1) {
        //         c--;
        //     }
        // }
        // if (c == 0)
        //     return true;
        // return false;

        char[] ch = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        boolean[] arr = new boolean[128];
        char[] str = s.toCharArray();
        for (char c : ch) {
            arr[c] = true;
        }

        int c = 0;
        int mid = str.length / 2;
        for (int i = 0; i < mid; i++) {
            if (arr[str[i]]) {
                c++;
            }
            if (arr[str[i + mid]]) {
                c--;
            }
        }
        return c == 0;
    }
}