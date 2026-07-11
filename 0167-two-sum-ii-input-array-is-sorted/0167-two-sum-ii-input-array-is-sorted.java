class Solution {
    public int[] twoSum(int[] arr, int t) {
        int n= arr.length;
        HashMap<Integer,Integer> map= new HashMap<>();


        for(int i=0;i<n;i++){
            int x= t-arr[i];

            if(map.containsKey(x)){
return new int[]{map.get(x), i + 1};            }

            map.put(arr[i],i+1);

        }
     return new int[] {-1, -1};
        
    }
}