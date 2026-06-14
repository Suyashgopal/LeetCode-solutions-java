class Solution {
    public int fib(int n) {
        if(n<=1){return n;}
        int p2=0;
        int p1=1;
        for(int i=0;i<n-1;i++){
            int res= p2+p1;
            p2= p1;
            p1= res;

        }
        return p1;
        
    }
}