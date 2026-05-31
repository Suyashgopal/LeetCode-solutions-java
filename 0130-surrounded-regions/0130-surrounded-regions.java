import java.util.*;

class pair{
    int i;
    int j;
    pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}


class Solution {
    public void solve(char[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];
        for(int i=0;i<row;i++){
            if(mat[i][0]=='O' && !visit[i][0]){
                visit[i][0]= true;
                dfs(i,0,mat,visit);
            }
            if(mat[i][col-1]=='O' &&!visit[i][col-1]){
                visit[i][col-1]= true;
                dfs(i,col-1,mat,visit);
            }
        }
        for(int j=0;j<col;j++){
            if(mat[0][j]=='O' &&!visit[0][j]){
               visit[0][j]= true;
               dfs(0,j, mat, visit);
            }
            if(mat[row-1][j]=='O' && !visit[row-1][j]){
                visit[row-1][j]= true;
                dfs(row-1,j,mat,visit);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]=='O'&& !visit[i][j]){
                    mat[i][j]= 'X';
                }
            }
        }
        

    }

    void dfs(int i ,int j, char[][] mat, boolean[][] visit){
         int row= mat.length;
        int col= mat[0].length;
        visit[i][j]= true;
        for(int deli=-1; deli<=1; deli++ ){
            for(int delj=-1;delj<=1; delj++){
                if(Math.abs(deli)+Math.abs(delj)!=1){continue;}
                int ni= i+ deli;
                int nj= j+ delj;
                if(ni>=0 && ni< row && nj>=0 && nj<col && mat[ni][nj]=='O'&& !visit[ni][nj]){
                    visit[ni][nj]= true;
                    dfs(ni,nj,mat, visit);

                }


            }
        }


    }




}