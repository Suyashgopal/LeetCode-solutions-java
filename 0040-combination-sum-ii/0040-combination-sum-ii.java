class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int t) {
        List<List<Integer>> outer= new ArrayList<>();
        List<Integer> al= new ArrayList<>();
        Arrays.sort(arr);
        fun(0, arr,t,al,outer);
        return outer;

        
    }
    void fun(int id, int [] arr, int t,List<Integer> al, List<List<Integer>> outer){
        if(t==0){
            outer.add(new ArrayList<>(al));
            return;
        }
        if(id>= arr.length || t<0){
            return ;
        }




        //pick

        al.add(arr[id]);
        fun(id+1, arr, t-arr[id],al, outer);

        //remove last ones
        int x= al.get(al.size()-1);

        al.remove(al.size()-1);

        while(id<arr.length && arr[id]==x){
            id++;
        }
        fun(id, arr,t, al, outer);
    }
}