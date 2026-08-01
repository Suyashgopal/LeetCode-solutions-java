class Solution {
    public boolean isValid(String s) {
       char [] arr= s.toCharArray();
       int n= arr.length;
       Stack<Character> st= new Stack<>();

       for(int i=0;i<n;i++){

        char c= arr[i];

        if(c=='['  || c=='{'  || c=='('  ){
        st.push(c);
        }

        else{
             if(st.isEmpty()){return false;}

             if(c==']'  ) {
                if(st.peek()== '[')
                { st.pop();}
              else { return false;}
              
             }
             if(c=='}'  ) {
                if(st.peek()== '{')
                { st.pop();}
                else { return false;}
              
             }
              if(c==')'  ) {
                if(st.peek()== '(')
                { st.pop();}
                else { return false;}
              
             }
        }





       }

       if(st.isEmpty()){
        return true;
       }
       return false;
        
    }
}