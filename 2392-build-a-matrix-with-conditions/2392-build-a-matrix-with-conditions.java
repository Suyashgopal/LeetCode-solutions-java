class Solution {
    public int[][] buildMatrix(int k, int[][] rowc, int[][] colc) {
        
        List<List<Integer>> adjrow= new ArrayList<>();
        int [] deg= new int[k+1];
        
        for(int i=0;i<=k;i++){
            adjrow.add(new ArrayList<Integer>());
        }
        for(int i=0;i<rowc.length;i++){
            int a= rowc[i][0];
            int b= rowc[i][1];
            adjrow.get(a).add(b);
            deg[b]++;}

            //by kahn
            Queue<Integer> q=  new LinkedList<>();
            for(int i=1;i<=k;i++){
                if(deg[i]==0){
                    q.add(i);
                }
            }

        ArrayList<Integer> rowid= new ArrayList<>();
        while(!q.isEmpty()){
            int curr= q.poll();
            rowid.add(curr);
            for(int a: adjrow.get(curr)){
                deg[a]--;
                if(deg[a]==0){ q.add(a);}
            }
        }





        List<List<Integer>> adjcol= new ArrayList<>();

        int [] deg1= new int[k+1];
        
        for(int i=0;i<=k;i++){
            adjcol.add(new ArrayList<Integer>());
        }
        for(int i=0;i<colc.length;i++){
            int a= colc[i][0];
            int b= colc[i][1];
            adjcol.get(a).add(b);
            deg1[b]++;}

            //by kahn
            Queue<Integer> q1=  new LinkedList<>();
            for(int i=1;i<=k;i++){
                if(deg1[i]==0){
                    q1.add(i);
                }
            }

        ArrayList<Integer> colid= new ArrayList<>();
        while(!q1.isEmpty()){
            int curr= q1.poll();
            colid.add(curr);
            for(int a: adjcol.get(curr)){
                deg1[a]--;
                if(deg1[a]==0){ q1.add(a);}
            }
        }
int[][] res= new int[k][k];

if(rowid.size() < k || colid.size() < k)
    return new int[0][0];
for(int[] r:res){
    Arrays.fill(r,0);
}
  for(int i=0;i<rowid.size();i++){
    int val= rowid.get(i);
    int j= colid.indexOf(val);
    res[i][j]= val;
  }
 return res;



        
    }
}