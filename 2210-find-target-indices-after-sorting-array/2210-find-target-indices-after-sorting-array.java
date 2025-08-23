class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
              int num=0,tcount=0;
        for(int ele:nums){
            if(ele==target){
                tcount++;
            }
            else if(ele<target){
                num++;
            }
            System.out.println("ele: " + ele + " num: " + num + " tcount: " + tcount);
        }
        List<Integer> ans=new ArrayList<>();
        while(tcount>0){
            ans.add(num);
            num++;
            tcount--;
        }
        return ans;    }

}