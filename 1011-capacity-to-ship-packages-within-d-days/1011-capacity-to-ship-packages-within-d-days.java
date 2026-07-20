class Solution {
    public int shipWithinDays(int[] arr, int days) {
        
        int n= arr.length;
        int low= 0;
        int high=0;
        for(int i= 0;i<n;i++){
            low= Math.max(low, arr[i]);
            high= high + arr[i];

        }

        while(low< high){
            int mid= low + (high-low)/2;
            int myday= cal(mid, arr);

            if(myday<= days){
                high = mid;
            }
            else{
               low= mid+1;
            }
        }
        return low;

    }
    int cal(int cap, int [] arr){
        int sum=0;
        int day=1;
        for(int i=0;i< arr.length;i++){
            if(sum + arr[i] <=cap){
                sum= sum+arr[i];

            }
            else{
                day++;
                sum=arr[i];
            }
        }
      
        return day;
    }
}