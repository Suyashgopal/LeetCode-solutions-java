class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n1=g.length;
        int n2 = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            if(g[i]<= s[j]){
                res++;
                i++;
                j++;    }

            else if (g[i]>s[j]){
                  j++;
            }
            else {
                return res;
            }
        }
        return res;
    }
}