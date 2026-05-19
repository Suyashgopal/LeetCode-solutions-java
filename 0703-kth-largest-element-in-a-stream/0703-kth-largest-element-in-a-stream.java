class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> pq;


    public KthLargest(int k, int[] nums) {

        this.k= k;
        this.nums= nums;
      this.pq= new PriorityQueue<>();
      for(int i: nums){
        pq.offer(i);
        if(pq.size()>k){
            pq.poll();
        }
      }



    }
    
    public int add(int val) {
        KthLargest obj = new KthLargest(k, nums);
       pq.offer(val);
       if(pq.size()>k){
        pq.poll();
       } return pq.peek();
        
        }
        
    }


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */