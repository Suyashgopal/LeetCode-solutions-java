class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> outer= new ArrayList<>();
        List<String> al= new ArrayList<>();

        fun(0, s,al, outer);
        return outer;



        
        
    }

    void fun(int id,String s ,  List<String> al, List<List<String>> outer ){
    int n= s.length();
    if(id==n){
        outer.add(new ArrayList<>(al));
        return ;
    }

    for(int len=1; id+len<=n; len++){
        int st = id;
        int end= id+len;
        
         //picked
        String k= s.substring(id, end);
        StringBuilder sb = new StringBuilder(k);
        String rev= sb.reverse().toString();
        if(rev.equals(k)){
            al.add(k);
              fun(end,s,al, outer );
                al.remove(al.size()-1);
        }

      

        
        
    }




        }
}