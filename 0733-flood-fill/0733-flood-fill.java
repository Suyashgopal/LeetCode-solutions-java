
class Solution {
    public int[][] floodFill(int[][] mat, int sr, int sc, int color) {
        
   int row= mat.length;
   int col= mat[0].length;

    boolean[][] visit= new boolean[row][col];
    int my= mat[sr][sc];
    dfs(sr,sc,visit,mat,color,my);
    return mat;

   

 
    }
    void dfs(int i,int j, boolean[][] visit, int[][] mat, int color ,int my){
        my= mat[i][j];
        visit[i][j]= true;
        mat[i][j]= color;
         int row= mat.length;
         int col= mat[0].length;
        for(int delrow=-1; delrow<=1; delrow++){
            for(int delcol=-1; delcol<=1; delcol++){
                if(Math.abs(delrow)+ Math.abs(delcol)!=1){continue;}
                 int nr= i+delrow;
                 int nc= j+ delcol;
                 if(nr>=0 && nr<row && nc>=0 && nc< col && mat[nr][nc]==my  && !visit[nr][nc]){
                    dfs(nr,nc, visit, mat, color,my);
                 }
            }
        }

    
    }
}