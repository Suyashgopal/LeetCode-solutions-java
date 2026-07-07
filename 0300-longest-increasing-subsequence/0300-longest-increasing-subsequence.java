class Solution {
    public int lengthOfLIS(int[] arr) {
        int n= arr.length;
        ArrayList<Integer> al= new ArrayList<>();
        al.add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]>al.get(al.size()-1)){
                al.add(arr[i]);
            }
            else{
                int id= binaryput(arr[i], arr, al);
                al.set(id, arr[i]);
            }
        }
        return al.size();
        
    }
    int binaryput(int target, int[] arr, ArrayList<Integer> al){
        int low=0;
        int high= al.size()-1;

        while(low<high){
            int mid= low+ (high-low)/2;
            if(al.get(mid)== target){
                return mid;
            }
           else if(al.get(mid)< target){
                low= mid+1;
            }
            else{
                high= mid;
            }
        

        }
        return low;

    }
}