class Solution {
    public String reverseWords(String s) {

        String[] stArray = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String str : stArray) {
            StringBuilder sb = new StringBuilder(str);

            ans.append(sb.reverse() + " ");

        }
        return ans.toString().trim();

    }
}