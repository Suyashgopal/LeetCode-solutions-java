class Solution {
    public String reverseWords(String st) {
       String s= st.trim();
        String[] arr= s.split("\\s+");
        StringBuilder sb= new StringBuilder();
        int n= arr.length;
        for(int i= n-1;i>0;i--){
           
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[0]);
        return sb.toString();

        
    }
}