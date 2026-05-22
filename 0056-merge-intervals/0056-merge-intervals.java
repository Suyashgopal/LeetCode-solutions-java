class Solution {
    public int[][] merge(int[][] mat) {
        int n= mat.length;
        Arrays.sort(mat, (a,b)->a[0]-b[0]);
        int i=0;
        List<int[]> al= new ArrayList<>();

        while(i<n){
          int min= mat[i][0];
          int max= mat[i][1];
          while(i<n-1 && mat[i+1][0]<= max){
           i++;
            max= Math.max(max,mat[i][ 1]);
          }
          al.add(new int [] {min, max});
          i++;
        }

int [][] res= al.toArray(new int [al.size()][]);
return res;
        
    }
}