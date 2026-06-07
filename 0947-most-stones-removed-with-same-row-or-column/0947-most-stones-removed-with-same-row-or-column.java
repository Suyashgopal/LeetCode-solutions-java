class dsu{
    List<Integer> rank= new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    public dsu(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);

        }
    }
    
    int findparent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int fp= findparent(parent.get(node));
        parent.set(node, fp);
        return parent.get(node);


    }

    void union( int u, int v){
        int fpu= findparent(u);
        int fpv= findparent(v);
        if(fpu== fpv){
            return;
        }
        else if(rank.get(fpu)> rank.get(fpv)){
            parent.set(fpv, fpu);
        }
         else if(rank.get(fpu)< rank.get(fpv)){
            parent.set(fpu, fpv);
        }
         else {
               parent.set(fpv, fpu);
            int ranku= rank.get(fpu);
            rank.set(fpu, ranku+1);

         
        }
    }






}


class Solution {
    public int removeStones(int[][] stones) {
        int n= stones.length;
        dsu dsu1= new dsu(n);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]== stones[j][0] || stones[i][1]== stones[j][1]){
                    dsu1.union(i, j);
                }
            }
        }


  int grp=0;
        for(int i=0;i<n;i++){
            int pi= dsu1.parent.get(i);
            if(i==pi){
             grp ++;
            }
        }
        return n-grp;
        
    }
}