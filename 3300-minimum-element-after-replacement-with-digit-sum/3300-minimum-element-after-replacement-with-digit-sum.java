class Solution {
  public int minElement(int[] nums) {
    int min = digitSum(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int sum = digitSum(nums[i]);
      min = Math.min(min, sum);
    }
    return min;
  }

  private int digitSum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }

    return sum;

  }
}