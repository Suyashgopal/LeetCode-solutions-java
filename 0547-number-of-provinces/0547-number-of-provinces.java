class Solution {
    public int findCircleNum(int[][] arr) {
        int n= arr.length;
  boolean[] visit= new boolean[n];

  //make a adj list
  List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                adj.get(i).add(j);

                }
            }
        }
 int count=0;

      for(int i=0;i<n;i++){
        if(!visit[i]){
            dfs(i,adj,visit);
            count++;
        }
      }  
return count;
        
    }

    void dfs(int i, List<List<Integer>> adj, boolean[] visit ){
        visit[i]= true;
        for(int k: adj.get(i)){
            if(!visit[k]){
                dfs(k, adj, visit);
            }
        }
    }
}