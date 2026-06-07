class dsu{
    List<Integer> parent= new ArrayList<>();
    List<Integer> rank= new ArrayList<>();
    int extrawire=0;
public dsu(int n){
     for(int i=0;i<n;i++){
        parent.add(i);
        rank.add(0);

     }}

     public int findparent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int fparent= findparent(parent.get(node));
        parent.set(node, fparent);
        return parent.get(node);

     }
     public void union(int u , int v){
        int fparentu= findparent(u);
        int fparentv= findparent(v);
        if(fparentu== fparentv){
            extrawire++;
            return;
        }
        else if(rank.get(fparentu)<rank.get(fparentv)){
            parent.set(fparentu, fparentv);

        }
           else if(rank.get(fparentu)>rank.get(fparentv)){
            parent.set(fparentv, fparentu);
            
        }
        else{
            parent.set(fparentv, fparentu);
            int ranku= rank.get(fparentu);
            rank.set(fparentu, ranku+1);

        }
    
     }


}





class Solution {
    public int makeConnected(int n, int[][] mat) {
        dsu dsu1 = new dsu(n);
        for(int i=0;i<mat.length;i++){
            dsu1.union(mat[i][0], mat[i][1]);
        }
        int count=0;
    //find the comp without parent
    for(int i=0;i<n;i++){
        int fpi= dsu1.findparent(i);

        if(i== fpi){
        count++;
        }}
        count= count-1;
        
        int extra=dsu1.extrawire;
        if(extra<count){
            return -1;
        }
   return count;
    





        
    }
}