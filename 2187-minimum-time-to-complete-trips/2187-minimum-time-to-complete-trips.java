class Solution {
    public long minimumTime(int[] arr, int total) {
        int n= arr.length;
        if(n==1){
            return (long )arr[0]* (total);
        }
        long low=(int) 1e9;
        for(int i=0;i<n;i++){
        low= Math.min(low,(long) arr[i]);
        }

        long high= total*low;


        while(low<high){
            long mid= (low)+(high- low)/2;
          long mytrip= fun(mid, arr);

          if(mytrip>= (long)total){
            high= mid;
          }
          else{
            low= mid+1;
          }
        }
        return low;

        
    }

    long fun(long time , int[] arr){
    long mytrip= 0L;

    for(int i=0;i<arr.length;i++){
        mytrip = mytrip + (long) time/arr[i];
    }
     
     return mytrip;


    }
}