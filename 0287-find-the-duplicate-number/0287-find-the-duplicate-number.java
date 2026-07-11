class Solution {
    public int findDuplicate(int[] arr) {
        int n= arr.length;
        int[] freq= new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            if(freq[arr[i]-1]==1){
              return   arr[i];
            }
            freq[arr[i]-1]++;
        } 
        return res;

    }
}