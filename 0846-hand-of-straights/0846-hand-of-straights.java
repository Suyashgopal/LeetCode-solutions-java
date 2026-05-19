class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {

       int n= hand.length;
        if(n%gs!=0 ){
            return false;
        }
        //store in hashmap
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }
        //store in a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int k: map.keySet()){
            pq.offer(k);
        }
   

   //take the smallest element and look for their consequtive 
   while(!pq.isEmpty()){
    int start= pq.peek();
    for(int i=0;i<gs;i++){
        int curr= start+i;
        if(!map.containsKey(curr)){
            return false;
        }
        
            map.put(curr, map.get(curr)-1);
            if(map.get(curr)==0){
                if(curr!= pq.peek()){
                    return false;
                }
                pq.poll();
                
            }
        
    }
   }  return true;

    }

}