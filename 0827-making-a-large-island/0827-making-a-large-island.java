class dsu {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    dsu(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }


    int findparent(int node) {
        if (parent.get(node) == node) {
            return node;
        }

        int fp = findparent(parent.get(node));
        parent.set(node, fp);

        return fp;
    }


    void union(int u, int v) {

        int fpu = findparent(u);
        int fpv = findparent(v);

        if (fpv == fpu) {
            return;
        }

        if (size.get(fpu) > size.get(fpv)) {

            parent.set(fpv, fpu);
            size.set(fpu, size.get(fpv) + size.get(fpu));

        } 
        else {

            parent.set(fpu, fpv);
            size.set(fpv, size.get(fpv) + size.get(fpu));
        }
    }

}




class Solution {
    public int largestIsland(int[][] mat) {

        int n = mat.length;

        dsu dsu1 = new dsu(n * n);

        int[] di = {-1,0,1,0};
        int[] dj = {0,-1,0,1};



        // Step 1: Make existing islands
        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(mat[i][j]==0){
                    continue;
                }

                int u = i*n + j;


                for(int k=0;k<4;k++){

                    int ni = i + di[k];
                    int nj = j + dj[k];


                    if(ni>=0 && ni<n && 
                       nj>=0 && nj<n && 
                       mat[ni][nj]==1){

                        int v = ni*n + nj;

                        dsu1.union(u,v);
                    }
                }
            }
        }



        int ans = 0;


        // Step 2: Try flipping every zero

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){

                if(mat[i][j]==1){
                    continue;
                }


                HashSet<Integer> set = new HashSet<>();


                for(int k=0;k<4;k++){

                    int ni = i + di[k];
                    int nj = j + dj[k];


                    if(ni>=0 && ni<n &&
                       nj>=0 && nj<n &&
                       mat[ni][nj]==1){

                        int v = ni*n + nj;

                        set.add(dsu1.findparent(v));
                    }
                }



                int total = 1; // flipped zero


                for(int parent : set){

                    total += dsu1.size.get(parent);
                }


                ans = Math.max(ans,total);

            }
        }



        // Step 3: already full island case

        for(int i=0;i<n*n;i++){

            ans = Math.max(ans,
                 dsu1.size.get(dsu1.findparent(i)));
        }



        return ans;

    }
}