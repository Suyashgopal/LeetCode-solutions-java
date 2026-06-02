class pair{
    int node;
    int d;
    pair(int node, int d){
        this.node= node;
        this.d= d;
    }
}


class Solution {
    public int ladderLength(String sw, String ew, List<String> wlist) {
        if(!wlist.contains(ew)){
            return 0;
        }

        wlist.addFirst(sw);
     int idxoflast =wlist.indexOf(ew);
        wlist.remove(idxoflast);
        wlist.add(ew);

        //making a adjlist;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

        for(int i=0;i<wlist.size();i++){
         adj.add(new ArrayList<Integer>());
        }


        for(int i=0;i<wlist.size()-1;i++){
            for(int j=i+1;j<wlist.size();j++){
                if(i==j){continue;}
               int diff= compares(wlist.get(i), wlist.get(j));
               if(diff==1){
                adj.get(i).add(j);
                adj.get(j).add(i);
               }

            }
        }
        Queue<pair> q= new LinkedList<>();
        int [] dist= new int[adj.size()];
        Arrays.fill(dist, (int)1e9);
        q.add(new pair(0,0));
        dist[0]=0;


        shortpath(q, adj,dist);
    if(dist[dist.length-1]==1e9){
        return 0;
    }

   return dist[dist.length-1]+1;

    

    }

  int compares(String a, String b){
    int res=0;
    int i=0;
    int j=0;
    while(i< a.length()){
        if(a.charAt(i)!= b.charAt(j)){
            res++;
        }
        i++;
        j++;
    }
    return res;
  }


   void shortpath(Queue<pair> q,ArrayList<ArrayList<Integer>> adj, int[] dist )
{
    while(!q.isEmpty()){
        pair curr= q.poll();
        int node= curr.node;
        int cdist= curr.d;
        for(int i=0;i<adj.get(node).size(); i++){
            int nn= adj.get(node).get(i);
            if(dist[nn]==1e9){
              dist[nn]= Math.min(cdist+1, dist[nn]);
               q.offer(new pair(nn, dist[nn]));
                }
              dist[nn]= Math.min(cdist+1, dist[nn]);


        }
    }
}
}