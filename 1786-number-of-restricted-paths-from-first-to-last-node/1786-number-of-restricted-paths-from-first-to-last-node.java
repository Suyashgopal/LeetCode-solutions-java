class pair{
    int wt;
    int node;
    pair(int wt, int node){
        this.wt= wt;
        this.node= node;

    }

}


class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<pair>> adj= new ArrayList<>();
        int[] dist= new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<pair>());
        }
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int wt= edges[i][2];
            adj.get(u).add(new pair( wt,v));
            adj.get(v).add(new pair( wt,u));

        }
      TreeSet<pair> set = new TreeSet<>((a,b)->{
    if(a.wt == b.wt)
        return Integer.compare(a.node, b.node);
    return Integer.compare(a.wt, b.wt);
});

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[n]=0;
    set.add(new pair(0,n));
    while(!set.isEmpty()){
        pair curr= set.pollFirst();
        int cwt= curr.wt;
        int cnode= curr.node;
        if(dist[cnode]<cwt){continue;}
        for(pair a: adj.get(cnode)){
            int awt= a.wt;
            int anode= a.node;
            if(dist[anode]> awt+cwt){
                set.add(new pair(awt+cwt, anode));
                dist[anode]= awt+cwt;
            }
        }


    }

  long mod=1000000000+7;
    
   //make a dag
   List<List<Integer>> dag = new ArrayList<>();

for(int i=0;i<=n;i++){
    dag.add(new ArrayList<>());
}


// build DAG
for(int[] e : edges){

    int u=e[0];
    int v=e[1];

    if(dist[u] > dist[v]){
        dag.get(u).add(v);
    }
    else if(dist[v] > dist[u]){
        dag.get(v).add(u);
    }
}


// topo
int[] indeg=new int[n+1];

for(int u=1;u<=n;u++){
    for(int v: dag.get(u)){
        indeg[v]++;
    }
}

Queue<Integer> q=new LinkedList<>();

for(int i=1;i<=n;i++){
    if(indeg[i]==0)
        q.add(i);
}


long[] ways=new long[n+1];

ways[1]=1;

while(!q.isEmpty()){

    int u=q.poll();

    for(int v: dag.get(u)){

        ways[v]=(ways[v]+ways[u])%mod;

        indeg[v]--;

        if(indeg[v]==0)
            q.add(v);
    }
}

return (int)ways[n];
        
    }

}