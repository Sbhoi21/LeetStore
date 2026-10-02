class Solution {
    public String reversePrefix(String word, char ch) {

        int index = word.indexOf(ch);

        if (index == -1) {
            return word;
        }

       
       char[] chr = word.toCharArray();

       int left = 0, right = index;

       while (left < right) {
            char t = chr[left];
            chr[left] = chr[right];
            chr[right] = t;
            left++;
            right--;
       }

       return new String(chr);



    }
}