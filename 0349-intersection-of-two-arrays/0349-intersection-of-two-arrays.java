class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int n1= nums2.length;
        HashSet<Integer> set= new HashSet<>();

        

        for(int i=0;i<n;i++){
          set.add(nums1[i]);
        }
        ArrayList<Integer> li= new ArrayList<>();
        for(int i=0;i<n1;i++){
            if(set.contains(nums2[i]) && !li.contains(nums2[i])){
                li.add(nums2[i]);
            }
        }
        return  li.stream().mapToInt(Integer::intValue).toArray();
   }
}