class Solution {
    public int singleNumber(int[] arr) {
        
        int n= arr.length;
        int res=0;

        for(int i=0;i<32 ;i++){
            int count=0;
         for(int j=0;j<n;j++){
           int bitmask= (arr[j]>>i) & 1;
           if(bitmask==1){
            count++;
           }
         }
         if(count%3!=0){
        res=    res | (1<<i);
         }
        }
        return res;
    }
}