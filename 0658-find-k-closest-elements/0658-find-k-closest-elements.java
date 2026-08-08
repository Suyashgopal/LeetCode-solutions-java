class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
  PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]); // smaller element first
            }
        );

        int n= arr.length;
        for(int i=0;i<n;i++){
            int dist= Math.abs(arr[i]- x);
            pq.add(new int[]{ arr[i], dist});
        }

        PriorityQueue<Integer> pq1= new PriorityQueue<>();
        List<Integer> al= new ArrayList<>();
        for(int i=0;i<k;i++){
            int[] curr= pq.poll();
            pq1.offer(curr[0]);

        }

         for(int i=0;i<k;i++){
           al.add(pq1.poll()) ;
         }
        
        return al;
    }
}