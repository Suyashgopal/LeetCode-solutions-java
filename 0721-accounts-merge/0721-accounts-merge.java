class dsu {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    public dsu(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }

    public int findparent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int fp = findparent(parent.get(node));
        parent.set(node, fp);

        return fp;
    }


    public void union(int u,int v){

        int fpu = findparent(u);
        int fpv = findparent(v);

        if(fpu == fpv){
            return;
        }

        if(rank.get(fpu) > rank.get(fpv)){
            parent.set(fpv,fpu);
        }
        else if(rank.get(fpv) > rank.get(fpu)){
            parent.set(fpu,fpv);
        }
        else{
            parent.set(fpv,fpu);
            rank.set(fpu,rank.get(fpu)+1);
        }
    }
}



class Solution {

    public List<List<String>> accountsMerge(List<List<String>> acc) {

        int n = acc.size();

        dsu dsu1 = new dsu(n);


        // connect same person accounts
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                if(!acc.get(i).get(0).equals(acc.get(j).get(0))){
                    continue;
                }

                if(hascommon(i,j,acc)){
                    dsu1.union(i,j);
                }
            }
        }


        HashMap<Integer,TreeSet<String>> map = new HashMap<>();

        for(int i=0;i<n;i++){

            int parent = dsu1.findparent(i);

            map.putIfAbsent(parent,new TreeSet<>());

            for(int j=1;j<acc.get(i).size();j++){
                map.get(parent).add(acc.get(i).get(j));
            }
        }


        List<List<String>> res = new ArrayList<>();

        for(int key : map.keySet()){

            List<String> temp = new ArrayList<>();

            temp.add(acc.get(key).get(0));
            temp.addAll(map.get(key));

            res.add(temp);
        }


        return res;
    }


    boolean hascommon(int a,int b,List<List<String>> acc){

        List<String> al1 = acc.get(a);
        List<String> al2 = acc.get(b);


        for(int k=1;k<al1.size();k++){

            if(al2.contains(al1.get(k))){
                return true;
            }
        }

        return false;
    }
}