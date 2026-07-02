class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;
        

        int[] ahead= new int[2];
        int[] curr= new int[2];
        ahead[0]= ahead[1]= 0;
        
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){

              int profit=0;
                if(j==1){
            
            profit= Math.max(-arr[i]+ ahead[0],ahead[1]); 
        }

         if(j==0){
          
            profit= Math.max(arr[i]+ ahead[1] , ahead[0] );
        }
        curr[j]= profit;}

        ahead= curr.clone();
        }

 return curr[1];






        
    }
   
}