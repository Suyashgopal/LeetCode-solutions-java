class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        int r= mat.length;
        int c= mat[0].length;
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(mat[i][j]!= mat[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}