class tuple {
    int dist;
    int r;
    int c;
    tuple(int dist, int r, int c){
        this.dist= dist;
        this.r= r;
        this.c= c;

    }
}



class Solution {
    public int shortestBridge(int[][] mat) {
        int n= mat.length;

     boolean[][] visit= new boolean[n][n];
     int si=0;
     int sj=0;


   outer:
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        if(mat[i][j]==1){
            si=i;
            sj=j;
            break outer;
        }
    }
}
dfs(si,sj,mat, visit);
// bfs function to count min
Queue<tuple> q= new LinkedList<>();


for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        if(visit[i][j]){
            q.add(new tuple(0, i,j));
        }

    }
}
 return bfs(q,mat, visit);





        
    }
    void dfs( int i, int j, int[][] mat,boolean[][] visit){
        int n= mat.length;
        if(visit[i][j]){return;}
        visit[i][j]= true;

        for(int di=-1;di<=1; di++){
            for(int dj=-1; dj<=1; dj++){
                if(Math.abs(di)+ Math.abs(dj)!= 1){continue;}
                int ni= i+di;
                int nj= j+ dj;
                if(ni>=0 && ni<n & nj>=0 && nj<n && !visit[ni][nj] && mat[ni][nj]==1){
                   dfs(ni, nj, mat, visit); 
                }
            }
        }

        return;
    }

   int bfs(Queue<tuple> q, int[][] mat, boolean[][] visit){
        int n = mat.length;

        while(!q.isEmpty()){

            tuple curr = q.poll();

            int i = curr.r;
            int j = curr.c;
            int d = curr.dist;


            for(int di=-1; di<=1; di++){
                for(int dj=-1; dj<=1; dj++){

                    if(Math.abs(di)+Math.abs(dj) != 1) continue;

                    int ni = i + di;
                    int nj = j + dj;


                    if(ni>=0 && ni<n && nj>=0 && nj<n 
                       && !visit[ni][nj]){

                        // reached second island
                        if(mat[ni][nj] == 1){
                            return d;
                        }

                        visit[ni][nj] = true;
                        q.add(new tuple(d+1, ni, nj));
                    }
                }
            }
        }

        return -1;
    }
}