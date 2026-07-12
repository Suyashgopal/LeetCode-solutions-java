class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n= arr.length;
        //pre calculate
        int[] pre= new int[n];
        pre[0]=1;
        for(int i=1;i<n;i++){
            pre[i]= pre[i-1]* arr[i-1];
            
        }
         int[] post= new int[n];
        post[n-1]=1;

        for(int i=n-2;i>=0 ;i--){
        post[i]= post[i+1] *arr[i+1];          
        }

        for(int i=0;i<n;i++){
            arr[i]= pre[i]*post[i];
        }
    return arr;
      
      

        
      
    }
}