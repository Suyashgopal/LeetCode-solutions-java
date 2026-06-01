class Solution {
    public List<Integer> eventualSafeNodes(int[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        ArrayList<Integer> res= new ArrayList<>();
        boolean[] pathvisit= new boolean[row];
       boolean[] visit= new boolean[row];
       for(int i=0;i<row;i++){
        if(!dfs(i,pathvisit,visit, mat)){
            res.add(i);
        }
       }
         return res;
    }
    boolean dfs(int st, boolean[] pathvisit, boolean[] visit, int [][] mat){
        pathvisit[st]= true;
        visit[st]= true;
        for(int k: mat[st]){
            if(!visit[k]){
                if(dfs(k, pathvisit, visit, mat)== true){
                    return true;
                }
            }
            else if(pathvisit[k]==true){
                return true;
            }
        }
        pathvisit[st]= false;
        return false;
    }
}