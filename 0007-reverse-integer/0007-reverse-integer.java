class Solution {
    public int reverse(int x) {
        long a =(long) Math.abs(x);
        long mul= 1;
        if(x<0){
            mul=-1;
        }
        long res=0;
        while(a>0){
            long k= a% 10l;
           
            res= res*10 + k;
             if((res> Integer.MAX_VALUE ) ||(res< Integer.MIN_VALUE )  ){
                return 0;
            }
            a=a/10;
        }
        if(mul==-1){
            return (int)-res;
        }

        return (int)res;
    }
}