class Solution {
    public int longestConsecutive(int[] arr) {
        int n= arr.length;
        if(n==0){return 0;}
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int res=1;
        
        for(int a: set){
            if(!set.contains(a-1)){
                int curr= a;
                int l=1;
                while(set.contains(curr+1)){
                    curr++;
                    l++;
                    res= Math.max(l, res);
                }
            }
        }
        return res;
    }
}