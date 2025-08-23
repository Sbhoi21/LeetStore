class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] bol = new boolean[26];
        for(char c:allowed.toCharArray()){
            bol[c-'a'] = true;
        }
        int count=0;
        for(String s:words){
            
            if(find(s,bol)){
                count++;
            }
        }
        return count;
    }
    private boolean find(String s,boolean[] arr){
        for(int i = 0; i < s.length(); ++i){
            if(!arr[s.charAt(i)-'a']){
                return false;
            }
        }
        return true;
    }
}