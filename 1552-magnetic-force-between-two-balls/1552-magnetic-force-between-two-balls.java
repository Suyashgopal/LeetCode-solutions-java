class Solution {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int n= arr.length;
        int low= 1;
        int high= arr[n-1]- arr[0];

       
     while(low<=high){
        int mid= low+ (high-low)/2;

    int myballs= fun(mid, arr);
    if(myballs>= m){
        low= mid+1;
    }
    else{
        high= mid-1;
    }
     }
     return high;
        
    }
    int fun(int diff, int[] arr){
        int balls= 1;
        int last=0;
        for(int i=1;i<arr.length;i++){
            if((arr[i]-arr[last])>= diff){
                balls++;
                last=i;
            }
        }
        return balls;
    }
}