class Solution {
    public int firstMissingPositive(int[] arr) {
    int n= arr.length;
    boolean[] seen= new boolean[n+1];
    for(int i=0;i<n;i++){
        if(arr[i]>0 && arr[i]<=n){
            seen[arr[i]]= true;
        }
    }
      for(int i=1;i<=n;i++){
        if(seen[i]==false){
            return i;
        }
      }  
      return n+1;
    }
}