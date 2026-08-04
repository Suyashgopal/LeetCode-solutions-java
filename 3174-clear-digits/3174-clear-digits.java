class Solution {
    public String clearDigits(String s) {
     char[] arr= s.toCharArray();
     int n= arr.length;
     Stack<Character> st= new Stack<>();
     for(int i=0;i<n;i++){
        char curr= arr[i];
        if(!st.isEmpty() && Character.isDigit(curr)){
            st.pop();
        }
        else{
            st.push(curr);
        }
     }

     StringBuilder sb= new StringBuilder();

     if(st.isEmpty()){
        return "";
     }

     while(!st.isEmpty()){
        sb.append(st.pop());
     }
     return sb.reverse().toString();

    }
}