class Solution {
    public int[] singleNumber(int[] arr) {
        int n= arr.length;

        //full xor
        int num=0;
        for(int i=0;i<n;i++){
            num= num^ arr[i];
        }

        //get the last set bit
        int num1= num & (-num);

        int lastsetbit=  num1;

        //bucket 1 for nums with ith set bit and 2 for not set bits

        int bucket1=0;
        int bucket2=0;

        for(int i=0;i<n;i++){
            int k= arr[i] & lastsetbit;

            if(k==0){
                bucket2= bucket2^arr[i];
            }
            else{
                bucket1= bucket1^ arr[i];
            }
        }

     return new int[] { bucket1, bucket2};
        
    }
}