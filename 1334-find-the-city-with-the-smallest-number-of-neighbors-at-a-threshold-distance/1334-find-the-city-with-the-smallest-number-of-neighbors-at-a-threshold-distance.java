class Solution {
    public int findTheCity(int n, int[][] edges, int max) {
        int [][] mat=  new int[n][n];
        for(int[] r: mat){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            mat[i][i]=0;
        }



        for(int i=0;i<edges.length;i++){
    
            int u = edges[i][0];
            int v= edges[i][1];
            int wt = edges[i][2];
            mat[u][v]= wt; 
            mat[v][u]= wt;
            
        }


        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][via]!= Integer.MAX_VALUE && mat[via][j]!= Integer.MAX_VALUE){
                    mat[i][j]= Math.min(mat[i][j], mat[i][via]+mat[via][j]);

                    }
                }
            }
        }
       int leastcity=Integer.MAX_VALUE;
       
       int ri=0;

       for(int i=0;i<n;i++){
        int lc =0;
        for(int j=0;j<n;j++){
           if(mat[i][j]<= max){
           lc++;
           }
        }
        if(lc<=leastcity){
            leastcity=lc;
            ri=i;
        }
  
       } 

  return ri;
        
    }
}