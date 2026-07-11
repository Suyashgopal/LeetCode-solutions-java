class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] c= s.toCharArray();
        int n= c.length;
   int[] alpha = new int[26];


    for(int i=0;i<n;i++){
       
       int idx= c[i]-'a';
       alpha[idx]=i;
    }
    List<Integer> al= new ArrayList<>();


    int min=0;
     int id= c[0]-'a';
     int max= alpha[id];

     for(int i=0;i<n;i++){
         id= c[i]-'a';
         int last= alpha[id];
        if(i>max){
            al.add(max-min+1);
            min= i;
            max= last; }
          else{
            min= Math.min(i, min);
            max= Math.max(last, max);
          }
     }
     al.add(max-min+1);
     return al;


        
    }
}