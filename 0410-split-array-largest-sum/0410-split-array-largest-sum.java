class Solution {
    public int splitArray(int[] arr, int k) {
        int n= arr.length;
        int low= Integer.MIN_VALUE;
        int high= 0;
        for(int i=0;i<n;i++){
            low= Math.max(low, arr[i]);
            high= high+arr[i];
        }

        while(low<=high){
            int mid= low+ (high-low)/2;
            int mygroup = fun(mid,arr);
            if(mygroup<=k){
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        
        return low;
    }

    int fun(int limit,int[] arr){
        int group=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
          if(sum+arr[i]<= limit){
            sum= sum+arr[i];
          }
          else{
            sum= arr[i];
            group++;
          }
        }
        if(sum>0){
            group++;
        }
        return group;
    }
}