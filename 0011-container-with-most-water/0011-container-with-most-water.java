class Solution {
    public int maxArea(int[] arr) {
        int n= arr.length;
        int i=0;
        int j= n-1;
        int max=0;
    while(i<j){
      int x= Math.min(arr[i], arr[j]);
      int res= x*(j-i);
      max= Math.max(max, res);
      if(arr[i]>arr[j]){
        j--;
      }
      else if(arr[j]>arr[i]){
        i++;
      }
      else{
        j--;
        i++;
      }
    }
       return max; 
    }
}