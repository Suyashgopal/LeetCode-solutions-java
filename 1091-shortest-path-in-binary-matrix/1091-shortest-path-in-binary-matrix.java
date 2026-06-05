class tuple{
    int dist;
    int row;
    int col;
    tuple(int dist, int row, int col){
        this.dist= dist;
        this.row= row;
        this.col= col;

    }

}


class Solution {
    public int shortestPathBinaryMatrix(int[][] mat) {
        int n= mat.length;





        if(mat[0][0]==1){return -1;}
    
//by djkstra
        int[][] d= new int[n][n];
      for(int[] row : d){
    Arrays.fill(row,  Integer.MAX_VALUE);
}

        d[0][0]=1;

        PriorityQueue<tuple> pq= new PriorityQueue<>(
            (x,y)-> x.dist-y.dist
        );

     pq.add(new tuple(1,0,0));
     while(!pq.isEmpty()){
        tuple curr= pq.poll();
        int currd= curr.dist;
        int  r= curr.row;
        int c= curr.col;
        for(int dr= -1; dr<=1; dr++){
            for(int dc= -1; dc<=1; dc++){
                if(dr==0 && dc==0){continue;}
                int nr= r+dr;
                int nc= c+dc;
                if(nr>=0 && nr<n && nc>=0 && nc<n && mat[nr][nc]==0 ){
                    if(d[nr][nc]>currd+1){
                        d[nr][nc]= currd+1;
                        pq.add(new tuple (currd+1, nr, nc));
                    }
                }
            }
        }

     }
      if(d[n-1][n-1]==  Integer.MAX_VALUE){
        return -1;
      }
 return d[n-1][n-1];
            

    }



}