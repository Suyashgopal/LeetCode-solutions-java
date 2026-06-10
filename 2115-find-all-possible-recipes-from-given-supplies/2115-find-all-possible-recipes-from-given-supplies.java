class Solution {
    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supplies) {

        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> indeg = new HashMap<>();

        for(int i = 0; i < recipes.length; i++){
            indeg.put(recipes[i], ingredients.get(i).size());

            for(String ing : ingredients.get(i)){
                map.putIfAbsent(ing, new ArrayList<>());
                map.get(ing).add(recipes[i]);
            }
        }

        Queue<String> q = new LinkedList<>();

        for(String s : supplies){
            q.add(s);
        }

        List<String> res = new ArrayList<>();

        while(!q.isEmpty()){
            String curr = q.poll();

            if(!map.containsKey(curr))
                continue;

            for(String recipe : map.get(curr)){
                indeg.put(recipe, indeg.get(recipe)-1);

                if(indeg.get(recipe)==0){
                    res.add(recipe);
                    q.add(recipe);
                }
            }
        }

        return res;
    }
}