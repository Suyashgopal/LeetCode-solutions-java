class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res= new int[k];
        int n= nums.length;
        //make a coustom priority queue
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        //maxheap on freq
        int[] max= new int [map.size()];
        int ptr=0;
       for(int xyz: map.keySet()){
        max[ptr]=xyz;
        ptr++;
       }

       int n1= max.length;
       int size=n1;
       for(int i=(n1/2)-1 ; i>=0;i-- ){
        downheap(max, i, map, n1);
       }
     //   poping and getting res
     for(int i=0;i<k;i++){
        res[i]= max[0];
        swap(max, 0, size-1);
        size--;
        downheap(max,0, map, size);
     }
     return res;

    }
    void swap(int[] arr, int a, int b){
        int temp= arr[a];
        arr[a]= arr[b];
        arr[b] = temp;

    }
     void downheap(int[] arr, int i  , HashMap<Integer,Integer> map, int size){
        int id= i;
        while(id<size/2){
            int max=id;
            int left= (2*id)+1;
            int right = (2*id)+2;
            if(left<size ){
                int leftnum= arr[left];
            int maxnum= arr[max];
            if(map.get(leftnum)> map.get(maxnum)){
                max= left;
            }
            }

              if(right<size ){
                int rightnum= arr[right];
            int maxnum= arr[max];
            if(map.get(rightnum)> map.get(maxnum)){
                max= right;
            }
            }


            if(max!= id){
                swap(arr,id, max);
                id= max;

            }
            else {
                break;
            }
        }



     }


}