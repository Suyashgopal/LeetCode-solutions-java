class pair{
    int node;
    long time;
    pair(int node, long time){
        this.node= node;
        this.time= time;
    }
}





class Solution {
    public int countPaths(int n, int[][] mat) {
        long mod= 1000000000+7;
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<pair>());
        }
        for(int i=0;i<mat.length;i++){
            adj.get(mat[i][0]).add(new pair(mat[i][1], mat[i][2]));
            adj.get(mat[i][1]).add(new pair(mat[i][0], mat[i][2]));

        }
        long[] dist= new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
                Arrays.fill(ways, Long.MAX_VALUE);
                dist[0]=0;
                ways[0]=1;

           PriorityQueue<pair> pq= new PriorityQueue<>((a,b)-> Long.compare(a.time, b.time));
           pq.add(new pair(0,0));


    while(!pq.isEmpty()){
        pair curr= pq.poll();
        int cnode= curr.node;
        long ctime= curr.time;
        if(ctime>dist[cnode]){continue;}
        for(pair a: adj.get(cnode)){
            long newtime = a.time+ctime;
            if(newtime < dist[a.node]){
                dist[a.node]= newtime;
                ways[a.node]= ways[cnode];
                pq.add(new pair(a.node, newtime));
            }
            else if(newtime == dist[a.node]){
       ways[a.node]= (ways[cnode]+ ways[a.node])% mod;
            }
        }

    }

 return (int) ways[n-1];
        
    }
}