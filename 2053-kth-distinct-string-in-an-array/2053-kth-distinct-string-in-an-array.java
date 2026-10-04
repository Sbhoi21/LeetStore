class Solution {
    public String kthDistinct(String[] arr, int k) {

        // Map<String, Integer> count = new HashMap();

        // for (String s : arr) {
        //     count.put(s, count.getOrDefault(s, 0) + 1);
        // }

        // for (String s : arr) {
        //     if (count.get(s) == 1)
        //         k--;
        //     if (k == 0)
        //         return s;
        // }
        // return "";

        Set<String> dups = new HashSet();
        Set<String> diff = new HashSet();

        for (String s : arr) {
            if (dups.contains(s))
                continue;
            else if (diff.contains(s)) {
                diff.remove(s);
                dups.add(s);
            } else {
                diff.add(s);
            }
        }

        for (String s : arr) {
            if (diff.contains(s))
                k--;
            if (k == 0)
                return s;
        }
        return "";

    }
}