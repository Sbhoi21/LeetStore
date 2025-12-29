class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build mapping: "AB" -> [C1, C2, ...]
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return dfs(bottom);
    }

    private boolean dfs(String row) {
        // If we reached the top
        if (row.length() == 1) return true;

        // Build all possible next rows
        return buildNextRow(row, 0, new StringBuilder());
    }

    private boolean buildNextRow(String row, int index, StringBuilder next) {
        if (index == row.length() - 1) {
            // Try building pyramid from the next row
            return dfs(next.toString());
        }

        String key = row.substring(index, index + 2);
        if (!map.containsKey(key)) return false;

        for (char c : map.get(key)) {
            next.append(c);
            if (buildNextRow(row, index + 1, next)) {
                return true;
            }
            next.deleteCharAt(next.length() - 1); // backtrack
        }

        return false;
    }
}