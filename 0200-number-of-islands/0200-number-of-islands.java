class Solution {
    public int numIslands(char[][] mat) {
        //convert mat to adj list
        List<List<Integer>> adj= new ArrayList<>();
        int row= mat.length;
        int col= mat[0].length;
        


            for(int i=0;i< (row* col) ;i++){
            adj.add(new ArrayList<Integer>());
             }
             int[] visit= new int[adj.size()+1];
             Arrays.fill(visit, 0);

      for(int i=0;i<row;i++){
       for(int j=0;j< col;j++){
        if(mat[i][j]=='1'){
            int num= i* col + j;
            visit[num]=1;
            adj.get(num).add(num);
            //its upper one
            if(i>0 && mat[i-1][j]=='1'){
             adj.get(num).add((i-1)*col+(j));
            }

            //its lower one
            if(i<row-1 && mat[i+1][j]=='1'){
             adj.get(num).add((i+1)*col+(j));
            }

            //its left one
            if(j>0 && mat[i][j-1]=='1'){
             adj.get(num).add((i)*col+(j-1));
            }

            //right one
             if(j<col-1 && mat[i][j+1]=='1'){
             adj.get(num).add((i)*col+(j+1));
            }}


       }
      }
     int count=0;
      for(int i=0;i<visit.length ;i++)
      {  if(visit[i]!=0){
          dfs(i,adj, visit);
          count++;
      }

      }
        
        return count;
        
    }
    void dfs( int i,List<List<Integer>> adj,int [] visit ){
        visit[i]=0;
        for(int k : adj.get(i)){
            if(visit[k]!=0){
            dfs(k, adj, visit);

            }
        }
    }
}