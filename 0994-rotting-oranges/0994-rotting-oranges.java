class tuple{
    int i;
    int j;
    int time;
    tuple(int i, int j ,int time){
        this.i=i;
        this.j=j;
        this.time= time;

    }
}



class Solution {
    public int orangesRotting(int[][] mat) {
    int row= mat.length;
    int col= mat[0].length;
  
 boolean[][] visit= new boolean[row][col];
 Queue<tuple> q= new LinkedList<>();

 for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
      if(mat[i][j]==2){
        q.offer(new tuple(i, j, 0));
      }
    }
 }
int[][] res= new int[row][col];

 return bfs(visit,q,res,mat);



        
        
    }
    int bfs(boolean[][] visit, Queue<tuple> q,int[][] res, int[][] mat ){
        int row= mat.length;
        int col= mat[0].length;
        int maxtime=0;
        while(!q.isEmpty()){
            tuple curr= q.poll();
            int i= curr.i;
            int j= curr.j;
            int time= curr.time;
            visit[i][j]= true;
            res[i][j]=2;

            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1; delcol<=1; delcol++){
                    if(Math.abs(delrow)+ Math.abs(delcol)!=1){continue;}
                    int nr= i+delrow;
                    int nc= j+ delcol;
                    if(nr>=0 && nr<row && nc>=0 && nc<col && !visit[nr][nc] && mat[nr][nc]==1){
                        visit[nr][nc]=true;
                        q.offer(new tuple(nr, nc,time+1));
                    }
                }
            }
            maxtime= time;
        }
     for(int i=0;i< row;i++){
        for(int j=0;j<col;j++){
            if(mat[i][j]==1 && res[i][j]!=2){
                return -1;
            }
        }
     }




        return maxtime;

    }
}