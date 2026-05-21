class Solution {
    public int candy(int[] r) {
        int n=r.length;
        int sum=0;
        int i=1;
        int[] res= new int[n];
        Arrays.fill(res,1);
        while(i<n){
            if(r[i-1]<r[i]){
                res[i]=res[i-1]+1;

            };
            i++;
        }
        i=n-2;
        while(i>=0){
            if(r[i]>r[i+1]){
            res[i] = Math.max(res[i], res[i+1] + 1);
            }
            i--;
        }
        for(int num: res){
     sum= sum+num;
        }
        return sum;
         
    }
}