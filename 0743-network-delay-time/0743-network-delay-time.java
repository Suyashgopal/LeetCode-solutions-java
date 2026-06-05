class pair{
    int time;
    int  node;
    pair(int node, int time){
        this.time= time;
        this.node= node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();


      for(int i=0;i<n+1;i++){
       adj.add(new ArrayList<pair>());
      }
      for(int i=0;i<times.length;i++){
        adj.get(times[i][0]).add(new pair(times[i][1], times[i][2]));
      }

      PriorityQueue<pair> pq= new PriorityQueue<>((a,b)-> a.time- b.time);
      int[] dist= new int[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[k]= 0;
      pq.add(new pair(k,0));
      while(!pq.isEmpty()){
        pair curr= pq.poll();
        int currtime= curr.time;
        int currnode= curr.node;
        for(pair a: adj.get(currnode)){
            int newtime= a.time + currtime;
            if(newtime<dist[a.node]){
                dist[a.node]= newtime;
                pq.add(new pair(a.node, newtime));
            }
        }
      }


      int max=0;
      for(int i=1;i<=n;i++){
        if(dist[i]==Integer.MAX_VALUE){return -1;}
        max= Math.max(max, dist[i]);

      }
       return max; 
    }
}