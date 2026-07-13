class Solution {
    public boolean isValidSudoku(char[][] mat) {
        HashMap<Integer, Set<Character>> rowmap= new HashMap<>();
        HashMap<Integer, Set<Character>> colmap= new HashMap<>();
         HashMap<Integer, Set<Character>> boxmap= new HashMap<>();
        for(int i=0;i<9;i++){
            rowmap.put(i, new HashSet<Character>());
            colmap.put(i, new HashSet<Character>());
            boxmap.put(i, new HashSet<Character>());
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(mat[i][j]!='.'){
        
                    

                    if(rowmap.get(i).contains(mat[i][j])){
                        return false;
                    }
                    if(colmap.get(j).contains(mat[i][j])){
                        return false;
                    }

                    int boxid= (i/3) *3 + (j/3);
                  
                    
                    if(boxmap.get(boxid).contains(mat[i][j])){
                        return false;
                    }

                    rowmap.get(i).add(mat[i][j]);
                   colmap.get(j).add(mat[i][j]);
                  boxmap.get(boxid).add(mat[i][j]);


                    
}

}}
   return true;

        

        
    }
}