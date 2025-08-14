class NumArray {

private int[] nums;
        private int[] tree;
        private int n;

    public NumArray(int[] nums) {
       this.nums = nums;
            int n = nums.length;
            tree = new int[n + 1];

            // Build the Fenwick Tree
            for (int i = 0; i < n; i++) {
                int index = i + 1; // Fenwick Tree is 1-indexed
                while (index < tree.length) {
                    tree[index] += nums[i];
                    index += index & -index; // Move to the next index
                }
            }

    }
    
    public void update(int index, int val) {
   int diff = val - nums[index];
            nums[index] = val;
            for (int i = index + 1; i < tree.length; i += i & -i) {
                tree[i] += diff;
            }
    }
    
    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
    }

         private int getSum(int index) {
       int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index; // Move to the parent index
            }
            return sum;
        }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */