class Solution {
    public boolean checkIfExist(int[] arr) {
  java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}