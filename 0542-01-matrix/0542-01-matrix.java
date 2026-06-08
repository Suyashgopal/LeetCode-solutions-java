class tuple{
    int dist;
    int r;
    int c;
    tuple(int dist, int r, int c){
        this.dist=  dist;
        this.r= r;
        this.c= c;

    }
}



class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        // using bfs
        Queue<tuple> q= new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    q.add(new tuple(0, i,j));
                }

            }
        }

        int[][] dist= new int [row][col];
         for(int[] a: dist){
            Arrays.fill(a, Integer.MAX_VALUE);
         }

        while(!q.isEmpty()){
            tuple curr= q.poll();
            int d= curr.dist;
            int r= curr.r;
            int c= curr.c;
            if(d>= dist[r][c]){continue;}
            dist[r][c]= d;
            for(int dr=-1; dr<=1;dr++){
                for(int dc=-1; dc<=1; dc++){
                    if(Math.abs(dr)+Math.abs(dc)!=1){continue;}
                    int nr= r+dr;
                    int nc= c+dc;
                    if(nr>=0 && nr<row && nc>=0 && nc< col && mat[nr][nc]==1 && dist[nr][nc]> d+1){
                        q.add(new tuple(d+1, nr, nc));
                    }
                }
            }

        }

   return dist;
        
    }
}


