class Solution {
    public int countTriplets(int[] arr) {
        int n= arr.length;
        //make a xor array
        int[] xor= new int[n];
        xor[0]= arr[0];
        for(int i=1;i<n;i++){
            xor[i]= arr[i] ^ xor[i-1];
        }
        int count=0;


        for(int i=0;i<n-1;i++){
            for(int j=i+1; j<n;j++){
                int sum= xor[j];
                if(i>0){
                    sum= xor[j]^ xor[i-1];
                }

                if(sum==0){
                    count= count+ (j-i);
                }



            }
        }


    return count;
        
    }
}