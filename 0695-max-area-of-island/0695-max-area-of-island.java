class Solution {
   
    public int maxAreaOfIsland(int[][] mat) {
        int max=0;
        int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];

   for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
        if(mat[i][j]==1 && !visit[i][j]){
            max= Math.max(max, dfs(i,j, mat, visit));
        }
    }

   }




      return max;  
    }
    int dfs(int si, int sj, int[][] mat, boolean[][] visit){
            int row= mat.length;
        int col= mat[0].length;
        if(visit[si][sj]){
            return 0;
        }
        visit[si][sj]= true;
        int size=1;

        for(int di=-1; di<=1;di++){
            for(int dj=-1; dj<=1;dj++){
                if(Math.abs(di)+Math.abs(dj)!=1){
                    continue;
                }
                int ni= si+di;
                int nj= sj+dj;
                if(ni>=0 && ni<row && nj>=0 && nj< col && mat[ni][nj]==1 && !visit[ni][nj] ){
                   size= size+  dfs(ni, nj, mat, visit);
                }
            }
        }
      return size;

    }
}