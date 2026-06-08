
class Solution {
   
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
    int row= mat.length;
    int col= mat[0].length;
    boolean[][] pacific=new boolean[row][col];
    boolean[][] atlantic=new boolean[row][col];
    Queue<int[]> pq= new LinkedList<>();
    Queue<int[]> aq= new LinkedList<>();
    
    for(int i=0;i<col;i++){
        pacific[0][i]= true;
        pq.add(new int[]{ 0,i});

     }
     for(int i=1;i<row;i++){
        pacific[i][0]= true;
        pq.add(new int[] {i,0});
     }

  for(int i=0;i<col;i++){
        atlantic[row-1][i]= true;
        aq.add(new int[]{ row-1,i});

     }
     for(int i=0;i<row;i++){
        atlantic[i][col-1]= true;
        aq.add(new int[] {i,col-1});

     }

      bfs(pacific, mat,pq);
      bfs(atlantic, mat, aq);
      List<List<Integer>> res= new ArrayList<>();

      for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
        if(pacific[i][j] && atlantic[i][j]){
          res.add( Arrays.asList(i,j));
        }}}

    


  

        return res;
    }
    void bfs(boolean[][] visit,int[][] mat,Queue<int[]> q){
           int row= mat.length;
    int col= mat[0].length;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int ci= curr[0];
            int cj= curr[1];
        
            for(int di=-1;di<=1;di++){
                for(int dj=-1;dj<=1;dj++){
                    if(Math.abs(di)+ Math.abs(dj)!=1){continue;}
                    int ni= ci+ di;
                    int nj= cj+ dj;
                    if(ni>=0 && ni<row && nj>=0 && nj< col && !visit[ni][nj] && mat[ni][nj]>= mat[ci][cj]){
                        visit[ni][nj]= true;
                        q.add(new int[]{ni, nj});
                        
                    }

                }
            }
            
        }

    }


}