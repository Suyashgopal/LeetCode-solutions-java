class Solution {
    public boolean checkValidString(String s) {  
        char[] c=s.toCharArray();
        int n= c.length;
        int mino=0;
        int maxo=0;
        for(int i=0;i<n;i++)
       { if(maxo<0){
        return false;
       }
        
        
        if(c[i]=='('){
        mino++;
        maxo++;
       }
       else if(c[i]=='*'){
        maxo++;
        if(mino>0){
            mino--;
        }
       }
       else if(c[i]==')'){
        maxo--;
        if(mino>0){
            mino--;
        }
       }

       }
      
      if(mino>0){
        return false;
      }
      if(maxo<0){
        return false;
       }
       return true;
 } 
}