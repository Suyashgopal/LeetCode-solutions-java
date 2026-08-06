class Solution {
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        int n= arr.length;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
        }

        while(pq.size()>1){
            int a= pq.poll();
            int b= pq.poll();
            if(a!=b){
                pq.offer(a-b);
            }
        }

        if(pq.size()==0){return 0;}
return pq.poll();

        
    }
}