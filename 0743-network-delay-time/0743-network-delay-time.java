class Solution {
    public int networkDelayTime(int[][] mat, int n, int k) {


        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]= 0;
        for(int i=0;i<n-1;i++){


            for(int j=0;j<mat.length;j++){
                int u= mat[j][0];
                int v= mat[j][1];
                int wt= mat[j][2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt< dist[v]){
                    dist[v]= dist[u]+wt;
                }
            }


        }

        int max=0;

        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){return -1;}
            max= Math.max(max, dist[i]);
        }


    return max;
  

        
    }
}