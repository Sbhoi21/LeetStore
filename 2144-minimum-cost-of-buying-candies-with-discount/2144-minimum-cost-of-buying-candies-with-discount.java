class Solution {
  public int minimumCost(int[] cost) {

    Arrays.sort(cost);
    int sum = 0;
    for (int i = 1, j = cost.length - 1; j >= 0; i++, j--) {
      if (i % 3 != 0) {
        sum += cost[j];
      }
    }
    return sum;
  }
}