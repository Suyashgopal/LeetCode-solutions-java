class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> outer= new ArrayList<>();
        List<Integer> al= new ArrayList<>();
        Arrays.sort(arr);
        
        fun(0, arr, al, outer);

        return outer;


        
    }
    void fun(int id, int[] arr, List<Integer> al, List<List<Integer>> outer){
        int n= arr.length;
        if(id>=n){
            outer.add(new ArrayList<>(al));
            return;
        }

        //pick

        al.add(arr[id]);
        fun(id+1, arr, al, outer);
        //notpick

        int x= al.get(al.size()-1);

        al.remove(al.size()-1);

        while(id<n && arr[id]==x){
            id++;
        }
        fun(id, arr, al, outer);


    }
}