class tuple{
    int i;
    int j;
    int dist;
    tuple(int i, int j, int dist){
        this.i= i;
        this.j= j;
        this.dist= dist;

    }
}


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col= mat[0].length;

        boolean[][] visit= new boolean[row][col];
        Queue<tuple> q= new LinkedList<>();
        int[][] res= new int[row][col];
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(mat[i][j]==0){
                visit[i][j]= true;
                q.offer(new tuple(i,j,0));
            }
        }
       }
       bfs(visit, q, res, mat);

   return res;
     
    }
    void bfs( boolean[][] visit, Queue<tuple> q, int[][] res, int[][] mat){
           int row = mat.length;
        int col= mat[0].length;

        while(!q.isEmpty()){
            tuple curr= q.poll();
            int i= curr.i;
            int j= curr.j;
            int dist= curr.dist;
            visit[i][j]= true;
            res[i][j]= dist;
            
            for(int delrow= -1; delrow<=1;delrow++){
                for(int delcol=-1; delcol<=1; delcol++){
                    if(Math.abs(delrow)+ Math.abs(delcol)!=1){continue;}
                    int nr= i+delrow;
                    int nc= j+delcol;
                    if(nr>=0 && nr<row && nc>=0 && nc<col && !visit[nr][nc]){
                        visit[nr][nc]= true;
                        q.offer(new tuple(nr, nc, dist+1));
                    
                    }

                }
            }




        }
    }

}