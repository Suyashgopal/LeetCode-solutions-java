class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb= new StringBuilder();
        List<String> outer= new ArrayList<>();

        fun(0, 0,sb,s,outer );
        return outer;

    }

    void fun(int id, int parts, StringBuilder sb, String s, List<String> outer) {
        int n = s.length();
        if (parts==4) {
            if (id == n) {
                outer.add(sb.substring(0, sb.length()-1));

            }
            return;
        }
        if(id==n){return;}

        for (int i = 1; i <= 3 && id+i<=n ; i++) {
            int end = id + i;
           
            String xyz = s.substring(id, end);
            int num = Integer.parseInt(xyz);

             // No leading zeros
            if (xyz.length() > 1 && xyz.charAt(0) == '0')
                break;

            if (num <= 255) {
                int oldlen= sb.length();
                sb.append(xyz).append(".");
                fun(end,parts+1,sb,s, outer);
                sb.setLength(oldlen);
                
     
            }
        }

    }
}