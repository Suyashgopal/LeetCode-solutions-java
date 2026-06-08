class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visit= new boolean[n];
        dfs(source,visit, adj);
        if(visit[destination]){
            return true;
        }
        return false;

    
    }
    void dfs(int src, boolean[] visit,ArrayList<ArrayList<Integer>> adj ){
        if(visit[src]){return;}
        visit[src]= true;
        for(int a : adj.get(src)){
            if(!visit[a]){
               dfs(a,visit,adj); 
            }
        }
        return;

    }

}