class tuple{
    int row;
    int col;
    int time;
    tuple(int time ,int row, int col){
     this.row= row;
     this.col= col;
     this.time= time;
    }
}



class Solution {
    public int swimInWater(int[][] mat) {
       int n= mat.length;
       PriorityQueue <tuple> pq= new PriorityQueue<>((a,b)-> a.time-b.time);
       pq.add(new tuple(mat[0][0],0,0));
       int[][] dist= new int[n][n];
       boolean[][] visit= new boolean[n][n];
     

       while(!pq.isEmpty()){
        tuple curr= pq.poll();
        int r= curr.row;
        int c= curr.col;
        int t= curr.time;
        if(visit[r][c]){continue;}
        visit[r][c]= true;
        if(r==n-1 && c==n-1){
            return t;
        }
        for(int dr=-1; dr<=1; dr++){
            for(int dc=-1; dc<=1;dc++){
                if(Math.abs(dr)+ Math.abs(dc)!=1){continue;}
                int nr= r+dr;
                int nc= c+dc;
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visit[nr][nc]){
                    int maxtime= Math.max(t, mat[nr][nc]);
                    pq.add(new tuple(maxtime, nr, nc));
                }
            }
        }
        
       }
return -1;
    }
}