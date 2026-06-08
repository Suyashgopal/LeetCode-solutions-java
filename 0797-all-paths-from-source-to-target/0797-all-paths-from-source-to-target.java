class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i< graph.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        int row= graph.length;
        int col= graph[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j]==0){continue;}
                adj.get(i).add(graph[i][j]);
            }
        }

 List<List<Integer>> res= new ArrayList<>();
 ArrayList<Integer> al= new ArrayList<>();
 dfs(0,res, al,adj);
 return res;


    }
    void dfs(int node,  List<List<Integer>> res, ArrayList<Integer> al, List<List<Integer>> adj ){
        al.add(node);
        if(node== adj.size()-1){
            res.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }

        for(int next: adj.get(node) ){
            dfs(next, res, al, adj);
        }
        if(al.size()>0){
 al.remove(al.size()-1);
        }
       
        return;


    }
}