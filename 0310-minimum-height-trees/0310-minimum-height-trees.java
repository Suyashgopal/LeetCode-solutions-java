class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         if (n == 1) return Arrays.asList(0);
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());

        }
        int[] deg= new int[n];
        for(int i=0;i<edges.length;i++){
          int u= edges[i][0];
          int v= edges[i][1];
          adj.get(u).add(v);
          adj.get(v).add(u);
          deg[u]++;
          deg[v]++;        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==1){q.offer(i);}
        }


     int rem= n;
     while(rem>2){
        int size=q.size();

      rem= rem-size;

      for(int i=0;i<size;i++){
        int leaf = q.poll();
        for(int a: adj.get(leaf)){
            deg[a]--;
            if(deg[a]==1){
                q.offer(a);

            }
        }
      }




     }
   return new ArrayList<Integer>(q);


    }}