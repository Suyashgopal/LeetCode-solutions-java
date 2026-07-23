class Solution {
    public int findGCD(int[] arr) {
        int n=arr.length;
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max, arr[i]);
        }

        return gcd(min, max);
        
    }

    int gcd(int a, int b){
        while(b!=0){
        int temp=b;
        b=a%b;

        a= temp;
    

        }

        return a;
    }
}