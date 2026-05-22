class Solution {
    public int eraseOverlapIntervals(int[][] mat) {
        int n= mat.length;
        Arrays.sort(mat, (a,b)-> a[1]-b[1]);
        int i=0;
        int count=0;
        int j=1;
    while(j<n){
        if(mat[i][1]>mat[j][0]){
            count++;
            j++;
        }
        else{
            i=j;
            j++;
        }
    }
    return count;
        
    }
}