class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n= nums.length;
        int mid= n/2;
        int mide= nums[mid];
        int ctr=0;
        for(int i=0;i<n;i++){
            if(nums[i]== mide){
                ctr++;
            }
        }
        if(ctr==1){
            return true;
        }
        return false;
    }
}