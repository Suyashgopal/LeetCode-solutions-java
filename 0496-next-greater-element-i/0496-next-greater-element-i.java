class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2= nums2.length;
        Stack<Integer> st= new Stack<>();
        int i= n2-1;
        HashMap<Integer, Integer> map= new HashMap<>();
        while(i>=0){
           while(!st.isEmpty() && st.peek()<nums2[i]){
                    st.pop();
                }

                if(st.isEmpty() ){
                    st.push(nums2[i]);
                    map.put(nums2[i], -1);
                }

                else{
                    map.put(nums2[i], st.peek());
                    st.push(nums2[i]);
                }
                i--;
            
        }
        int n= nums1.length;

        int[] res= new int[n];
        for(int j=0; j<n; j++){
            res[j]= map.get(nums1[j]);
        }
        return res;

 


        
    }
}