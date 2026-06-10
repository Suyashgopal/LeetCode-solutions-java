

class pair{
    int move;
    String val;
    pair(int move,String val){
        this.move= move;
        this.val= val;
    }
}




class Solution {
    public int openLock(String[] dead, String end) {

     HashSet<String> dend= new HashSet<>();  
     for(String a: dead){
        dend.add(a);
     }
     if(dend.contains("0000")){
      return -1;
     }
    
     HashSet<String> visit= new HashSet<>();
     Queue<pair> q= new LinkedList<>();
     q.add(new pair(0,"0000"));
     visit.add("0000");
     while(!q.isEmpty()){
        pair curr= q.poll();
        if(end.equals(curr.val)){return curr.move;}

        for(int i=0;i<4;i++){
            char[] arr= curr.val.toCharArray();
            String next;
            String next1;

            //up

            if(arr[i]=='9'){
              arr[i]='0';
               next= new String (arr);
            }
            else{
             arr[i]++;
              next=  new String (arr);
            }
            if(!visit.contains(next) && !dend.contains(next) ){
                visit.add(next);
               q.add(new pair(curr.move+1, next));
            }
             arr= curr.val.toCharArray();

            //down
          if(arr[i]=='0'){
              arr[i]='9';
               next1=  new String (arr);
            }
            else{
             arr[i]--;
              next1=  new String (arr);
            }
            if(!visit.contains(next1) && !dend.contains(next1) ){
                visit.add(next1);
               q.add(new pair(curr.move+1, next1));
            }

        }
}
   return -1;
    }}