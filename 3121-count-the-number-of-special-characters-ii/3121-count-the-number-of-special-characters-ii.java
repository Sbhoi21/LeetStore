class Solution {
  public int numberOfSpecialChars(String word) {
    int[] lower = new int[26];
    int count = 0;
    for (char c : word.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        if (lower[c - 'a'] == 2) {
          count--;
          lower[c - 'a'] = 3;
        }
        if (lower[c - 'a'] == 0)
          lower[c - 'a'] = 1;
      }
      if (c >= 'A' && c <= 'Z') {
        if (lower[c + 32 - 'a'] == 1) {
          count++;
          lower[c + 32 - 'a'] = 2;
        }
        if (lower[c + 32 - 'a'] == 0) {
          lower[c + 32 - 'a'] = 3;
        }
      }
    }

    return count;

  }
}