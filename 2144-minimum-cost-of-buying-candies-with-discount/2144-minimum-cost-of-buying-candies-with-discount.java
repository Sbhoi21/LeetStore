class Solution {
  public int minimumCost(int[] cost) {

    int[] count = new int[101];
    for (int c : cost)
      count[c]++;

    int sum = 0, t = 1;
    int n = cost.length;

    for (int i = 100; i > 0; i--) {
      while (count[i] > 0) {
        if (t % 3 != 0) {
          sum += i;
        }
        count[i]--;
        t++;
      }
    }
    return sum;
  }
}