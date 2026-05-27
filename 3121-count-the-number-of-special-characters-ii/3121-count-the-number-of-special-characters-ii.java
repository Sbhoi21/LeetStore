class Solution {
  public int numberOfSpecialChars(String word) {
    boolean[] lower = new boolean[26];
    boolean[] upper = new boolean[26];
    int count = 0;

    for (char c : word.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        if (lower[c - 'a'] == true && upper[c - 'a'] == true) {
          count--;
          lower[c - 'a'] = false;
        }
        if (lower[c - 'a'] == false && upper[c - 'a'] == false) {
          lower[c - 'a'] = true;
        }
      }
      if (c >= 'A' && c <= 'Z') {
        if (lower[c - 'A'] == true && upper[c - 'A'] == false) {
          count++;
        }
        upper[c - 'A'] = true;
      }
    }

    return count;

  }
}