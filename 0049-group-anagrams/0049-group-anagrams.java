class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res= new ArrayList<>();
         HashMap<String,Integer> map= new HashMap<>();
         int n= strs.length;
         for(int i=0;i<n;i++){
            char[] ch= strs[i].toCharArray();
            Arrays.sort(ch);
            String comp= new String(ch);
            if(map.containsKey(comp)){
             int id=   map.get(comp);
             res.get(id).add(strs[i]);
            }
            else{
             ArrayList<String> al= new ArrayList<>();
             al.add(strs[i]);
             res.add(al);
             map.put(comp, res.size()-1);
            }

         }
         return res;
        
    }
}