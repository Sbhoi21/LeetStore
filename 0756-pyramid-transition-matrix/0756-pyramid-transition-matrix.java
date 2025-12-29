class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String base = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }
        
        return backtrack(bottom, "", map);
    }

    private boolean backtrack(String current, String next, Map<String, List<Character>> map) {
        if (current.length() == 1) {
            return true;
        }
        if (next.length() == current.length() - 1) {
            return backtrack(next, "", map);
        }

        int i = next.length();
        String base = current.substring(i, i + 2);

        if (map.containsKey(base)) {

            for (char top : map.get(base)) {
                if (backtrack(current, next + top, map)) {
                    return true;
                }
            }
        }

        return false;
    }
}