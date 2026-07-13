class Solution {
    public void gameOfLife(int[][] mat) {
        int r= mat.length;
        int c= mat[0].length;
        int[][] live= new int[r][c];
        int [] di ={-1,-1,-1, 0, 0,1,1,1};

        int[] dj= {-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int d=0;d<8;d++){
                    int ni= i+di[d];
                    int nj= j + dj[d];
                    if(ni>=0 && ni<r && nj>=0 && nj<c && mat[ni][nj]==1){
                        live[i][j]= live[i][j]+1;
                    }
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    if((live[i][j]<2) || (live[i][j]>3)){
                        mat[i][j]=0;
                    }

                
                }
                else{
                    if(live[i][j]==3){
                        mat[i][j]=1;
                    }
                }
            }
        }
        
    }
}