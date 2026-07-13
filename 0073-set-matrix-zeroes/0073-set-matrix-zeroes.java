class Solution {
    public void setZeroes(int[][] mat) {
        int r= mat.length;
        int c= mat[0].length;


        boolean[][] z= new boolean[r][c];
        for(boolean[] k: z){
            Arrays.fill(k, false);
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    z[i][j]= true;
                }
            }
        }
          for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(z[i][j]){
                    makezero(i,j, mat);
                  
                }
            }
        }

        
    }
    void makezero(int a, int b, int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(i==a || j==b){
                    mat[i][j]=0;
                }
            }
        }
    }
}