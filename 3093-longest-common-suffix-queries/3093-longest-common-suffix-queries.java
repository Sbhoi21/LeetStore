class Solution {

  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int bestIndex = -1;
  }

  TrieNode root = new TrieNode();

  public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

    for (int i = 0; i < wordsContainer.length; i++) {
      insert(wordsContainer[i], i, wordsContainer);
    }

    int[] ans = new int[wordsQuery.length];

    for (int i = 0; i < wordsQuery.length; i++) {
      ans[i] = search(wordsQuery[i]);
    }

    return ans;
  }

  private void insert(String word, int index, String[] wordsContainer) {
    TrieNode node = root;

    updateBest(node, index, wordsContainer);

    for (int i = word.length() - 1; i >= 0; i--) {
      int ch = word.charAt(i) - 'a';

      if (node.children[ch] == null) {
        node.children[ch] = new TrieNode();
      }

      node = node.children[ch];

      updateBest(node, index, wordsContainer);
    }
  }

  private void updateBest(TrieNode node, int index, String[] wordsContainer) {
    if (node.bestIndex == -1) {
      node.bestIndex = index;
      return;
    }

    String currentBest = wordsContainer[node.bestIndex];
    String newWord = wordsContainer[index];

    if (newWord.length() < currentBest.length()) {
      node.bestIndex = index;
    } else if (newWord.length() == currentBest.length() && index < node.bestIndex) {
      node.bestIndex = index;
    }
  }

  private int search(String query) {
    TrieNode node = root;

    for (int i = query.length() - 1; i >= 0; i--) {
      int ch = query.charAt(i) - 'a';

      if (node.children[ch] == null) {
        break;
      }

      node = node.children[ch];
    }

    return node.bestIndex;
  }

}