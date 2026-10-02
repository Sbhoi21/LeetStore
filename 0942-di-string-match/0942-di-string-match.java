class Solution {
    public int[] diStringMatch(String s) {
        
        int n = s.length() + 1;
        int[] arr = new int[n];

        int i = 0;
        int left = 0;
        n--;
        for (char c: s.toCharArray()) {
            if (c == 'I') {arr[i++] = left++;}
            if (c == 'D') {arr[i++] = n--;}
        }
        arr[i] = left;
    
        return arr;
    }
}