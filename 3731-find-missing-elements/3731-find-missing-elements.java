class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        boolean arr[] = new boolean[101];
        int max = 0, min = 101;
        for (int i : nums) {
            arr[i] = true;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int left = min;
        List<Integer> ans = new ArrayList<Integer>();
        while (left <= max) {
            if (arr[left] == false) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }
}