class Solution {
    public int firstMissingPositive(int[] arr) {
        int n= arr.length;
        int max=0;
     HashSet<Integer> set= new HashSet<>();
     for(int i=0;i<n;i++){
    set.add(arr[i]);
    max= Math.max(max,arr[i]);
     }
     

     for(int i=1;i<max;i++){
        if(!set.contains(i)){
            return i;
        }
     }
     return max+1;
    }
}