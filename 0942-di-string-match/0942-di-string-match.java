class Solution {
    public int[] diStringMatch(String s) {
        
        int n = s.length();
        int[] arr = new int[n+1];

        int i = 0;
        int left = 0;
        for (char c: s.toCharArray()) {
            if (c == 'I') {arr[i++] = left++;}
            if (c == 'D') {arr[i++] = n--;}
        }
        arr[i] = left;
    
        return arr;
    }
}