class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
          int repeat;
        int[] count=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            repeat=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    repeat++;

                }
            }
            count[i]=repeat;
        }
        return count;
    }
}