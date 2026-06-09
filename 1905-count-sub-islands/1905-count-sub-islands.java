class Solution {
    public int countSubIslands(int[][] mat1, int[][] mat2) {
        int row= mat1.length;
        int col= mat1[0].length;

        boolean[][] visit= new boolean[row][col];
        
        int count=0;
     for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if( mat2[i][j]==1 && !visit[i][j]){
              boolean isset=  bfs(i,j,mat1,mat2,visit);
              if(isset){count++;}
            }
        }
     }
        
  return count;



        
    }
  


    boolean bfs(int i, int j, int[][] mat1,int[][] mat2, boolean[][] visit){
        int row= mat1.length;
        int col= mat1[0].length;
        boolean isset= true;
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int ci= curr[0];
            int cj= curr[1];
            if(mat1[ci][cj]==0){ isset= false;}
            if(visit[ci][cj]){continue;}
            visit[ci][cj]= true;
            for(int di= -1; di<=1; di++){
                for(int dj=-1; dj<=1;dj++){
                    if(Math.abs(di)+ Math.abs(dj)!=1){continue;}
                    int ni= ci+ di;
                    int nj= cj + dj;
                    if(ni>=0 && ni< row && nj>=0 && nj<col && !visit[ni][nj] && mat2[ni][nj]==1){
                        q.add(new int[]{ni,nj});
                    }
                }
            }
        }
        return isset;
    }

}