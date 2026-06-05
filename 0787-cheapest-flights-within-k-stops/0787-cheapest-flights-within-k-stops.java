class tuple{
    int node;
    int price;
    int stops;
    tuple(int price, int node, int stops){
        
        this.price= price;
        this.node= node;
        this.stops=stops;

    }}
    class pair{
        int node;
        int price;
        pair(int node, int price){
        this.node= node;
        this.price= price;
    }
    }
   

    






class Solution {
    public int findCheapestPrice(int n, int[][] mat, int src, int dest, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<pair>());
        }
        for(int i=0;i<mat.length;i++){
            adj.get(mat[i][0]).add(new pair(mat[i][1], mat[i][2]));
        }

        int[] dist= new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        
        Queue<tuple> pq= new LinkedList<>( );
        pq.add(new tuple(0, src, 0));

        while(!pq.isEmpty()){
            tuple curr= pq.poll();
            int node= curr.node;
            int stops= curr.stops;
            int price = curr.price;
            if(stops>k){
                continue;
            }
            for(pair a: adj.get(node)){
               int newprice= a.price+price;
                 
                if(newprice<dist[a.node] && stops<=k){
                    dist[a.node]= newprice;
                    pq.add(new tuple( newprice, a.node,stops+1));
                }

            }


        }

        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dest];


    }
}











