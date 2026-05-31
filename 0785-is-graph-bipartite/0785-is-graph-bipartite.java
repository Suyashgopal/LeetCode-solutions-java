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

        for(int i=0;i<row;i++){
            if(colour[i]==-1){
                boolean res= dfs(i,-1,mat, colour);
                if(!res){return false;}
            }
        }
    
return true;

    
    }
 boolean dfs(int st, int prevc,int[][] mat,int[] colour){
    if(prevc==-1){
     colour[st]=0;

    }
    else{
        colour[st]= 1-prevc;
    }
    for(int k: mat[st]){
        if(colour[k]==-1){
           if(!dfs(k,colour[st], mat, colour)){
            return false;
           }
        }
        else if(colour[k]== colour[st]){
            return false;
        }
    }


return true;
 }

}