class Solution {
    public int minSpeedOnTime(int[] arr, double hour) {
        if (hour <= arr.length - 1)
    return -1;
        int n= arr.length;
        int low= 1;
        int high=(int) 1e7;
        

    while(low<high){
        int mid= low+ (high-low)/2;
        double myhrs= fun(mid, arr);
        if(myhrs<= hour){
           high= mid;    
        }
        else{
            low= mid+1;
        }
    }
    double k= fun(low, arr);

  
    return low;
        
    }
    double fun(int speed, int[] arr){
        double time=0d;
        for(int i=0; i<arr.length-1;i++){
            time= time+ (arr[i]+speed-1)/speed;

        }

        time= time+ (double) arr[arr.length-1]/speed;
        return time;
    }
}