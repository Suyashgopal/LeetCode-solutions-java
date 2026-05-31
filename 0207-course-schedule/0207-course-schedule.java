class Solution {
    public boolean canFinish(int v, int[][] edges) {
        boolean[] visit=new boolean[v];
                boolean[] pathvisit=new boolean[v];

                ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
                for(int i=0;i<v;i++){
                    adj.add(new ArrayList<Integer>());
                }
                for(int i=0;i<edges.length;i++){
                    adj.get(edges[i][0]).add(edges[i][1]);
                }
      for(int i=0;i<v;i++)
{
     if(!visit[i]){
        if(dfs(i,adj,visit, pathvisit)==true){
            return false;
        }
     }
    
}
        
      return true;  
    }
    boolean dfs(int st, ArrayList<ArrayList<Integer>> adj, boolean[] visit, boolean[] pathvisit){
     
        visit[st]= true;
        pathvisit[st]=true;

        for(int k: adj.get(st)){
            if(!visit[k]){
                if(dfs(k,adj,visit, pathvisit)== true){return true;}
            }
            else if(pathvisit[k]==true){
                return true;
            }
        }
  pathvisit[st]= false;
  return false;


    }
}