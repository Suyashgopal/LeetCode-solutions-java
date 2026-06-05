class tuple{
    int abs;
    int r;
    int c;
    tuple(int abs, int r, int c){
        this.abs= abs;
        this.r= r;
        this.c= c;
    }

}


class Solution {
    public int minimumEffortPath(int[][] mat) {

        int row=mat.length;
        int col= mat[0].length;
        int[][] dist= new int[row][col];
        PriorityQueue<tuple> q= new PriorityQueue<>(
            (x,y)->x.abs-y.abs
        );
        for(int[] i : dist){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        dist[0][0]=0;

        q.add(new tuple(0,0,0));

        while(!q.isEmpty()){
            tuple curr= q.poll();
            int pathabs=curr.abs;
            int r= curr.r;
            int c= curr.c;
            int ht= mat[r][c];

            for(int dr=-1;dr<=1;dr++){
                for(int dc=-1;dc<=1;dc++){
                    if(Math.abs(dr)+Math.abs(dc)!=1){continue;}
                    int nr= r+dr;
                    int nc= c+dc;
                    if(nr>=0 && nr<row && nc>=0 && nc<col){
                        int currhtdiff= Math.abs(mat[r][c]-mat[nr][nc]);
                        int newabs= Math.max(pathabs, currhtdiff);
                        if(newabs< dist[nr][nc]){
                            dist[nr][nc]=newabs;
                            q.add(new tuple(newabs, nr, nc));
                        }

                    }}}}






   return dist[row-1][col-1];


        
    }
}