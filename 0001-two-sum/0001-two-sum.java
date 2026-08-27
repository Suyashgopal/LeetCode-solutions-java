class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
        int diff= target-arr[i];
        if(map.containsKey(diff)){
            return new int[]{map.get(diff),i};
        }
        map.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }
}