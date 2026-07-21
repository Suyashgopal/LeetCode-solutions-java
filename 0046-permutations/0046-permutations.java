class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> outer= new ArrayList<>();
        List<Integer> al= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();

        fun(0, arr,al,set, outer);
        return outer;

        


        
    }

    void fun(int id,int[] arr,List<Integer> al,HashSet<Integer> set, List<List<Integer>> outer ){
        int n= arr.length;

        if(id==n){
            outer.add(new ArrayList<>(al));
            return;
        }
   

        for(int i=0;i<n;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                al.add(arr[i]);
                fun(id+1,arr, al,set,outer);
                al.remove(al.size()-1);
                set.remove(arr[i]);
            }
        }
    }
}