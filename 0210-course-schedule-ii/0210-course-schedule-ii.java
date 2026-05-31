
class Solution {
    public int[] findOrder(int v, int[][] edges) {
        boolean[] visit = new boolean[v];
        boolean[] pathvisit = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                if (dfs(i, res, adj, visit, pathvisit) == true) {
                    return new int[0];
                }
            }
        }
        Collections.reverse(res);
        int[] ans = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }




boolean dfs(int st, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj, boolean[] visit, boolean[] pathvisit){

    visit[st]= true;
    pathvisit[st]=true;



    for(int k: adj.get(st)){
        if(!visit[k]){
            if(dfs(k,res,adj,visit, pathvisit)== true){return true;}
        }
        else if(pathvisit[k]==true){
            return true;
        }
    }
    pathvisit[st]= false;
    res.add(st);
    return false;


}
}