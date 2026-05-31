import java.util.*;

class pair{
    int i;
    int j;
    pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}


class Solution {
    public void solve(char[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
        boolean[][] visit= new boolean[row][col];
        Queue<pair> q= new LinkedList<>();
        ArrayList<ArrayList<pair>> convert= new ArrayList<>();
        for(int i=0;i< row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]=='O' && !visit[i][j]){
                    visit[i][j]= true;
                    bfs(i, j, q,mat, visit, convert);

                }
            }
        }

        for(ArrayList<pair> li: convert){
            for(pair curr: li){
                int i= curr.i;
                int j= curr.j;
                if(mat[i][j]=='O'){
                    mat[i][j]='X';
                }
            }
        }

    }

    void bfs(int si ,int sj,Queue<pair> q,char[][] mat, boolean[][] visit, ArrayList<ArrayList<pair>> convert){
        ArrayList<pair> li= new ArrayList<>();
        int row= mat.length;
        int col= mat[0].length;
        visit[si][sj]= true;
        li.add(new pair(si,sj));
        boolean edgeflag= false;
        q.offer( new pair(si, sj));
        while(!q.isEmpty()){
            pair curr= q.poll();
            int i= curr.i;
            int j= curr.j;
            visit[i][j]= true;
            li.add(new pair(i,j));
            for(int delrow=-1;delrow<=1; delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(Math.abs(delrow)+ Math.abs(delcol)!=1){continue;}
                    int nr=i+ delrow;
                    int nc= j+ delcol;
                    if(nr<0 || nr>=row || nc<0 || nc>=col){
                        edgeflag= true;
                    }
                    if(nr>=0 && nr<row && nc>=0 && nc<col && mat[nr][nc]=='O' && !visit[nr][nc]){
                        visit[nr][nc]= true;
                        q.offer(new pair(nr, nc));
                    }


                }
            }
        }
        if(!edgeflag){
            convert.add(li);
        }
    }



}