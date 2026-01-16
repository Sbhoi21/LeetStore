class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long maxSide = -1;
        
        Set<Integer> hGaps = getGaps(m, hFences);
        Set<Integer> vGaps = getGaps(n, vFences);
        
        for (int gap : hGaps) {
            if (vGaps.contains(gap)) {
                maxSide = Math.max(maxSide, (long) gap);
            }
        }
        
        if (maxSide == -1) return -1;
        
        long mod = 1_000_000_007;
        return (int) ((maxSide * maxSide) % mod);
    }
    
    private Set<Integer> getGaps(int limit, int[] fences) {
        List<Integer> allFences = new ArrayList<>();
        allFences.add(1);
        allFences.add(limit);
        for (int f : fences) allFences.add(f);
        
        Collections.sort(allFences);
        
        Set<Integer> gaps = new HashSet<>();
        for (int i = 0; i < allFences.size(); i++) {
            for (int j = i + 1; j < allFences.size(); j++) {
                gaps.add(allFences.get(j) - allFences.get(i));
            }
        }
        return gaps;
    }
}