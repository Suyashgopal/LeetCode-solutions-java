class pair{
    double wt;
    int node;
     pair(double wt, int node){
      this.wt= wt;
      this.node= node;
    }
}



class Solution {
    public double maxProbability(int n, int[][] edges, double[] max, int st, int end) {
        List<List<pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<pair>());

        } 

        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            double p= max[i];
            adj.get(u).add(new pair(p,v));
             adj.get(v).add(new pair(p,u));

        }

        double[] prob= new double[n];
        Arrays.fill(prob,0);
        prob[st]=1;

TreeSet<pair> set = new TreeSet<>((a,b) -> {
    if(a.wt == b.wt)
        return Integer.compare(a.node, b.node);
    return Double.compare(b.wt, a.wt);
});

        set.add(new pair(1,st));
        while(!set.isEmpty()){
            pair curr= set.pollFirst();
            double currwt= curr.wt;
            int cnode= curr.node;
            if(prob[cnode]>currwt){
                continue;
            }
            prob[cnode]= currwt;
            for(pair a: adj.get(cnode)){
                if(prob[a.node]< a.wt *currwt){
                    set.add(new pair((a.wt*currwt), a.node ));
                    prob[a.node]= a.wt*currwt;
                }
            }
        }

        return prob[end];


        
    }
}