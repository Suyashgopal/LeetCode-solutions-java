class Solution {
    public int maxAreaOfIsland(int[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];
            int max=0;

   for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
        if(mat[i][j]==1 && !visit[i][j]){
            ArrayList<Integer> temp= new ArrayList<>();
            dfs(i,j, mat, visit, temp);
            max= Math.max(max, temp.size());
        }
    }

   }




      return max;  
    }
    void  dfs(int si, int sj, int[][] mat, boolean[][] visit, ArrayList<Integer> al){
            int row= mat.length;
        int col= mat[0].length;
        if(visit[si][sj]){
            return;
        }
        visit[si][sj]= true;
        al.add(mat[si][sj]);
        for(int di=-1; di<=1;di++){
            for(int dj=-1; dj<=1;dj++){
                if(Math.abs(di)+Math.abs(dj)!=1){
                    continue;
                }
                int ni= si+di;
                int nj= sj+dj;
                if(ni>=0 && ni<row && nj>=0 && nj< col && mat[ni][nj]==1 && !visit[ni][nj] ){
                    dfs(ni, nj, mat, visit, al);
                }
            }
        }
      return ;

    }
}