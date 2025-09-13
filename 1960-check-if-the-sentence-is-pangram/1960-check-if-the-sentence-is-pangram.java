class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26]; // To track each letter of the alphabet
        int uniqueCount = 0; // Count of unique letters seen

        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = Character.toLowerCase(c) - 'a';
                if (!seen[index]) {
                    seen[index] = true;
                    uniqueCount++;
                    if (uniqueCount == 26) { // All letters found
                        return true;
                    }
                }
            }
        }

        return uniqueCount == 26; 
    }
}