class Solution {
    public boolean lemonadeChange(int[] b) {
        int n= b.length;
        int acc=0;
         int[] c= new int[3];
         for(int i=0;i<n;i++){
            if(b[i]==5){
                c[0]++;
            }
            else if(b[i]==10){
                if(c[0]==0){
                    return false;
                }
                c[0]--;
                c[1]++;
            }
            else if(b[i]==20){
                if(c[1]>0 && c[0]>0){
                    c[1]--;
                    c[0]--;
                }
               else if(c[0]>2){
                    c[0]= c[0]-3;
                }
                else {
                    return false;
                }
            }
         }

        return true;
    }
}