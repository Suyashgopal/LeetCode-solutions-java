class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int i=0;

      while(i<n && arr[i]!=0){
        i++;
      }
      int j=i;
       while(j<n) {
        if(arr[i]==0 && arr[j]!=0){
            int temp= arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
            i++;
           

        }
    
        
   
            j++;
        
       }



        
    }
}