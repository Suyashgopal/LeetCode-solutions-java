class Solution {
    public int trap(int[] arr) {
        int n= arr.length;
        //nge to right
        int[] right= new int[n];
        int[] left= new int[n];
        int lg=-1;

       for(int i=n-1; i>=1;i--){
        if(arr[i]<=lg){
            left[i]= lg;
        }
        else{
            left[i]=-1;
            lg=arr[i];
        }
       } 
       int rg=-1;
       for(int i=0; i<n;i++){
        if(arr[i]<=rg){
            right[i]= rg;
        }
        else{
            right[i]=-1;
            rg=arr[i];
        }
       } 
       int sum=0;

       for(int i=0;i<n;i++){
     if(left[i]==-1 || right[i]==-1){
        continue;
     }
        int min= Math.min(left[i], right[i]);
        sum= sum+ (min-arr[i]);

       }   
       return sum;    
    }
}