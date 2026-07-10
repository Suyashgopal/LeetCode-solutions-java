class Solution {
    public int canCompleteCircuit(int[] g, int[] c) {


        int n= g.length;
        if(n==1){
            if(g[0]<c[0]){return -1;}
            return 0;
        }
        for(int i=0;i<n;i++){
            if(g[i]>c[i]){
                if(check(i,g, c)){
                    return i;
                }
            }
        }        
     return -1;
        

    }
 boolean check(int i, int[] g , int[] c){
  
    int n= g.length;
    int gas=0;
    int end= i+n;



    while(i<end){
        int id= i%n;
        gas= gas+ g[id];
        if(gas<c[id]){
            return false;
        }
        else{
            gas= gas-c[id];
            i++;
        }

        

    }

    return true;


 }
}