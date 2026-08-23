class Solution {
    public int getSum(int a, int b) {
        int sum=0;
        int carry=0;

        for(int i=0;i<32;i++){
            int abit=  (a>>>i ) & 1;
            int bbit=  (b>>>i ) & 1;
          

             if(carry==0){
                if((abit==0 && bbit==1) || (abit==1 && bbit==0)){
                  sum=   sum |(1<<i);

                }
              
               else if(abit==1 && bbit==1){
                    carry=1;
                }
             }

             else{
              if((abit==0 && bbit==1) || (abit==1 && bbit==0)){
                 carry= 1;

                }
               else if(abit==0 && bbit==0){
                   sum= sum | (1<<i);
                   carry=0;
                }
                else{
                   sum= sum | (1<<i);
                   carry=1;    

                }



             }


        
        }
        return sum;
        
    }
}