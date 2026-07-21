class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> outer= new ArrayList<>();
        List<Integer> al= new ArrayList<>();

        fun(0, arr, al, outer);
        return outer;

      
        
    }
    void fun(int id, int[] arr, List<Integer> al,List<List<Integer>> outer  ){
        if(id== arr.length){
            outer.add(new ArrayList<>(al));
            return;
        }
        //pick
        al.add(arr[id]);
        fun(id+1, arr, al, outer);

        //not pick
        al.remove(al.size()-1);
        fun(id+1, arr, al, outer);
    }
}