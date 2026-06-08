class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n= adj.size();
        boolean[] visit= new boolean[n];
        dfs(0, visit, adj);
        for(int i=0;i<n;i++){
            if(visit[i]==false){
                return false;
            }
        }
     return true;
        
    }
    void dfs(int st, boolean[] visit, List<List<Integer>> adj){
        if(visit[st]){return;}
        visit[st]= true;
        for(int a: adj.get(st)){
            if(!visit[a]){
                dfs(a,visit,adj);
            }
        }
        return;
    }

}