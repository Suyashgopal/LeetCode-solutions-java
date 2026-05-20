class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        if(n==1){
            return true;
        }
        int i=0;
        int maxreach=0;

        while(i<n-1){
            if(nums[i]==0){
                if(maxreach<=i){
                    return false;
                }

            }
            maxreach=Math.max(maxreach,i+ nums[i] ) ;
            i++;

     
        }
if(maxreach>=n-1){
    return true;
} return false;       
    }
}