class dsu{
    List<Integer> parent=new ArrayList<>();
        List<Integer> rank=new ArrayList<>();
        public dsu(int n){
            for(int i=0;i<n;i++){
                rank.add(0);
                parent.add(i);
            }
        }
       
       public int findparent(int node){
        if(node== parent.get(node)){
            return node;

        }
        int fp= findparent(parent.get(node));
        parent.set(node, fp);
        return parent.get(node);
       }

     public void union(int u, int v){
        int fpu= findparent(u);
        int fpv= findparent(v);
        if(fpu==fpv){
            return;
        }
        else if(rank.get(fpu)>rank.get(fpv)){
            parent.set(fpv, fpu);
        }
          else if(rank.get(fpv)>rank.get(fpu)){
            parent.set(fpu, fpv);
        }
        else {
            parent.set(fpv, fpu);
            int urank= rank.get(fpu);
            rank.set(fpu, urank+1);

        }
     }


}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n = acc.size();
        dsu dsu1= new dsu(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(! acc.get(i).get(0).equals(acc.get(j).get(0))){continue;}
               if(hascommon(i, j, acc)){
                    dsu1.union(i, j);
                }

            }
        }

      List<Integer> parent= dsu1.parent;
      HashMap< Integer, TreeSet<String>> map= new HashMap<>();
      for(int i=0;i<n;i++){
        int pi= dsu1.findparent(i);
        map.putIfAbsent(pi, new TreeSet<>());
        for(int k=1;k<acc.get(i).size();k++){
            map.get(pi).add(acc.get(i).get(k));

        }
      }

      
  List<List<String>> res= new ArrayList<>();
  for(int key :map.keySet()){
    List<String> temp= new ArrayList<>();
    temp.add(acc.get(key).get(0));
    temp.addAll(map.get(key));
    res.add(temp);  }
   




return res;


        
    }
    boolean hascommon(int i, int j,List<List<String>> acc){
        List<String> al1= acc.get(i);
        List<String> al2= acc.get(j);
         
         for(int a=1;a<al1.size();a++){
            if(al2.contains(al1.get(a))){return true;}
         }
         
         return false;
         }




}