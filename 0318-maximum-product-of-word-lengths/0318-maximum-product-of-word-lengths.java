class Solution {
    public int maxProduct(String[] words) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int n= words.length;
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=0;j<words[i].length();j++){
                int id=  words[i].charAt(j)-'a';
                num= num | (1<<id);


            }
            map.put(i,num);
        }
        int res=0;
        for(int i=0;i< n;i++){
            for(int j= i+1;j<n;j++){
                int b1= map.get(i);
                int b2= map.get(j);
                if((b1&b2) == 0){
                    int l1= words[i].length();
                    int l2= words[j].length();
                    int prod= l1* l2;

                 res= Math.max(res, prod);
                }
            }
        }
   return res;

        
    }
}