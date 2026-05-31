class Solution {
    public boolean isBipartite(int[][] mat) {
        int row= mat.length;
        int col= mat[0].length;
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

         for(int i=0;i<row;i++){
            adj.add(new ArrayList<Integer>());
         }
       

        int[] colour= new int[row];
        Arrays.fill(colour, -1);
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<row;i++){
            if(colour[i]==-1){
                boolean res= bfs(i,q,mat, colour);
                if(!res){return false;}
            }
        }
    
return true;

    
    }
 boolean bfs(int st, Queue<Integer> q,int[][] mat,int[] colour){
    q.add(st);
    colour[st]=0;
    while(!q.isEmpty()){
        int curr= q.poll();
        for(int k: mat[curr]){
            if(colour[k]==-1){
                q.add(k);
                colour[k]= 1- colour[curr];
            }
            else if(colour[k]== colour[curr]){
                return false;
            }
        }
    }
    return true;
 }

}