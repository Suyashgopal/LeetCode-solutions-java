class pair {
    int node;
    long time;

    pair(int node, long time){
        this.node = node;
        this.time = time;
    }
}


class Solution {
    public int countPaths(int n, int[][] mat) {

        int mod = (int)(1e9 + 7);

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<mat.length; i++){
            adj.get(mat[i][0]).add(new pair(mat[i][1], mat[i][2]));
            adj.get(mat[i][1]).add(new pair(mat[i][0], mat[i][2]));
        }


        PriorityQueue<pair> pq =
            new PriorityQueue<>((a,b)-> Long.compare(a.time,b.time));

        pq.add(new pair(0,0));


        while(!pq.isEmpty()){

            pair curr = pq.poll();

            int currnode = curr.node;
            long currtime = curr.time;

            if(currtime > dist[currnode]){
                continue;
            }


            for(pair a : adj.get(currnode)){

                long newtime = a.time + currtime;

                if(newtime < dist[a.node]){

                    dist[a.node] = newtime;
                    ways[a.node] = ways[currnode];

                    pq.add(new pair(a.node,newtime));
                }

                else if(newtime == dist[a.node]){

                    ways[a.node] =
                    (ways[a.node] + ways[currnode]) % mod;
                }
            }
        }

        return (int)ways[n-1];
    }
}
