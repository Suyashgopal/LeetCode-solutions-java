



class Solution {

    public int numIslands(char[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];
        int counter=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]=='1' && !visit[i][j]){
                    counter++;
                    bfs(i,j,mat,visit);
                }
            }
        }


         return counter;   


    }
    void bfs(int i, int j, char[][] mat, boolean[][] visit){
        int row= mat.length;
        int col= mat[0].length;
           Queue<ArrayList<Integer>> q = new LinkedList<>();
           visit[i][j]= true;
        q.offer(new ArrayList<>(Arrays.asList(i, j)));
        while(!q.isEmpty()){ 
           ArrayList<Integer> al= q.poll();
           i= al.get(0);
           j= al.get(1);
           for(int delrow=-1; delrow<=1;delrow++){
            for(int delcol=-1; delcol<=1 ; delcol++){
if(Math.abs(delrow) + Math.abs(delcol) != 1) continue;
                int nrow= i+delrow;
                int ncol= j+ delcol;
             if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && mat[nrow][ncol]=='1' && !visit[nrow][ncol]){
                visit[nrow][ncol]= true;
            q.offer(new ArrayList<>(Arrays.asList(nrow, ncol)));
              }
            }
           }
 }

    }}
    
    
