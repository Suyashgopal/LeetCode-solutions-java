class Solution {
    public int closedIsland(int[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];
        Queue<int[]> q= new LinkedList<>();

//mark edges visited
 int res=0;

     for(int i=1;i<row-1;i++){
        for(int j=1;j<col-1 ;j++){
            if(mat[i][j]== 0  && !visit[i][j]){
                q.add( new int[]{i,j});
                boolean add= bfs(visit,q, mat);
                if(!add){ res= res+1;}
            }
        }
     }
     return res;

    }
    boolean bfs(boolean[][] visit,Queue<int[]> q, int[][] mat ){
        int row= mat.length;
        int col= mat[0].length;
        boolean  isedge= false;
    while(!q.isEmpty()){
        int[] curr= q.poll();
        int i= curr[0];
        int j= curr[1];
        visit[i][j]= true;
        if(i==0 || i==row-1 || j==0 || j== col-1)
        { isedge= true;}
        for(int di=-1; di<=1; di++){
            for (int dj=-1; dj<=1; dj++){
                if(Math.abs(di)+ Math.abs(dj)!=1){continue;}
                int ni= i+di;
                int nj= j+ dj;
                
                if(ni>=0 && ni<row && nj>=0 &&  nj<col && !visit[ni][nj] && mat[ni][nj]==0){
                 visit[ni][nj]= true;
                 q.add( new int[]{ ni,nj});
                }
            }
        }
    }
       return isedge;
    }
}