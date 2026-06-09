class Solution {
    public int countSubIslands(int[][] mat1, int[][] mat2) {
        int row= mat1.length;
        int col= mat1[0].length;
        boolean[][] visit1= new boolean[row][col];
        boolean[][] visit2= new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat1[i][j]==1 && !visit1[i][j]){
                    bfs(i,j, mat1, visit1);
                }
            }
        }

     int count=0;
     for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(mat2[i][j]==1 && !visit2[i][j]){
              boolean isset=  bfs(i,j,mat2,visit1, visit2);
              if(isset){count++;}
            }
        }
     }
        
  return count;



        
    }
    void bfs(int i, int j, int[][] mat, boolean[][] visit){
        int row= mat.length;
        int col= mat[0].length;
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int ci= curr[0];
            int cj= curr[1];
            if(visit[ci][cj]){continue;}
            visit[ci][cj]= true;
            for(int di= -1; di<=1; di++){
                for(int dj=-1; dj<=1;dj++){
                    if(Math.abs(di)+ Math.abs(dj)!=1){continue;}
                    int ni= ci+ di;
                    int nj= cj + dj;
                    if(ni>=0 && ni< row && nj>=0 && nj<col && !visit[ni][nj] && mat[ni][nj]==1){
                        q.add(new int[]{ni,nj});
                    }
                }
            }
        }
    }


    boolean bfs(int i, int j, int[][] mat, boolean[][] visit1, boolean[][] visit2){
        int row= mat.length;
        int col= mat[0].length;
        boolean isset= true;
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int ci= curr[0];
            int cj= curr[1];
            if(!visit1[ci][cj]){ isset= false;}
            if(visit2[ci][cj]){continue;}
            visit2[ci][cj]= true;
            for(int di= -1; di<=1; di++){
                for(int dj=-1; dj<=1;dj++){
                    if(Math.abs(di)+ Math.abs(dj)!=1){continue;}
                    int ni= ci+ di;
                    int nj= cj + dj;
                    if(ni>=0 && ni< row && nj>=0 && nj<col && !visit2[ni][nj] && mat[ni][nj]==1){
                        q.add(new int[]{ni,nj});
                    }
                }
            }
        }
        return isset;
    }

}