class Solution {
    public String sortSentence(String s) {
             String[] array = s.split(" ");
		String[] result = new String[array.length];

		for (String word : array) {
			int i = Integer.parseInt(String.valueOf(word.charAt(word.length() - 1)));
			
			result[i - 1] = word.substring(0, word.length() - 1);
		}

		StringBuilder s1 = new StringBuilder();
		for (String word: result) {
			s1.append(word + " ");
		}
		return s1.toString().substring(0 , s1.length()-1);
    }
}