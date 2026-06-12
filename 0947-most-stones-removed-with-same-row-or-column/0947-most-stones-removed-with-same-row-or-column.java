class dsu{
    List<Integer> rank= new ArrayList<>();
        List<Integer> parent= new ArrayList<>();
         dsu(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                rank.add(0);
            }
        }


        int findparent(int node){
            if(parent.get(node)==node){
                return node;
            }
            int fp= findparent(parent.get(node));
            return fp;
        }
        void union(int u, int v){
            int fpu= findparent(u);
            int fpv= findparent(v);
            if(rank.get(fpu)> rank.get(fpv)){
                parent.set(fpv, fpu);

            }
            else if(rank.get(fpv)>rank.get(fpu)){
                parent.set(fpu,fpv);
            }
            else if(rank.get(fpv)==rank.get(fpu)){
                parent.set(fpv, fpu);
                int ranku= rank.get(fpu);
                rank.set(fpu, ranku+1);

            }
        }

}




class Solution {
    public int removeStones(int[][] mat) {
        int n= mat.length;

        dsu dsu1= new dsu(n);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(mat[i][0]==mat[j][0] || mat[i][1]== mat[j][1]){
                    dsu1.union(i,j);

                }
            }
        }


        int grps=0;
        for(int i=0;i<n;i++){
            if(dsu1.findparent(i)==i){
                grps++;
            }
        }
        return n-grps;

        
    }
}