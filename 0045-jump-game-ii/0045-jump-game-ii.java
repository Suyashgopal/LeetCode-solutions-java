class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int f=0;
        int c=0;
        int j=0;
        for(int i=0;i<n-1;i++){
            f= Math.max(f, nums[i]+i);
            if(i==c){
                   j++;
                c=f;
            }
        }

        return j;
    }
}