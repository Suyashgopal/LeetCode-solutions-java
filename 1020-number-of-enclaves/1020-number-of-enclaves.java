class Solution {
    public int numEnclaves(int[][] mat) {



         int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];
        for(int i=0;i<row;i++){
            if(mat[i][0]==1 && !visit[i][0]){
                visit[i][0]= true;
                dfs(i,0,mat,visit);
            }
            if(mat[i][col-1]==1 &&!visit[i][col-1]){
                visit[i][col-1]= true;
                dfs(i,col-1,mat,visit);
            }
        }
        for(int j=0;j<col;j++){
            if(mat[0][j]==1 &&!visit[0][j]){
               visit[0][j]= true;
               dfs(0,j, mat, visit);
            }
            if(mat[row-1][j]==1 && !visit[row-1][j]){
                visit[row-1][j]= true;
                dfs(row-1,j,mat,visit);
            }
        }
 int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1 && !visit[i][j]){
                    count++;
                }
            }
        }
        return count;
        
    }

       void dfs(int i ,int j, int[][] mat, boolean[][] visit){
         int row= mat.length;
        int col= mat[0].length;
        visit[i][j]= true;
        for(int deli=-1; deli<=1; deli++ ){
            for(int delj=-1;delj<=1; delj++){
                if(Math.abs(deli)+Math.abs(delj)!=1){continue;}
                int ni= i+ deli;
                int nj= j+ delj;
                if(ni>=0 && ni< row && nj>=0 && nj<col && mat[ni][nj]==1 && !visit[ni][nj]){
                    visit[ni][nj]= true;
                    dfs(ni,nj,mat, visit);

                }


            }
        }


    }
}





