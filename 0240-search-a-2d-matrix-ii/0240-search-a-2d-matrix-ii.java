class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int r= mat.length;
        int c= mat[0].length;
        int i=0;
        int j=c-1;
        while(i<r && j>=0){
            if(mat[i][j]==t){
                return true;
            }
            else if(mat[i][j]>t){
                j--;
            }
            else{
                i++;
            }
        }

        return false;
        
    }
}