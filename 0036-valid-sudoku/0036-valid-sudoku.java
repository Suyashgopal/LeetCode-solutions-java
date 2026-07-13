class Solution {
    public boolean isValidSudoku(char[][] mat) {
        boolean ans=true;
        for(int i=0;i<9;i++){
           if(!check(i, mat)){
            return false;
           }

        }
    

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i%3==0 &&( j%3==0)){
                    

                    if(!boxcheck(i,j, mat)){
                        return false;
                    }
                    
                }
            }
        }
        return true;


        
        
    }
    boolean check(int a, char[][] mat){
        HashSet<Character> row= new HashSet<>();
      HashSet<Character> col= new HashSet<>();
      for(int i=0;i<9;i++){
        if(mat[a][i]!='.' ){
             if(row.contains(mat[a][i])){
            return false;}
             row.add(mat[a][i]);
        }

          if(mat[i][a]!='.' ){
             if(col.contains(mat[i][a])){
            return false;}
             col.add(mat[i][a]);
        }
       

        }
      
       
      
      return true;

    }
    boolean boxcheck(int a, int b, char[][] mat){
        HashSet<Character> set= new HashSet<>();

        for(int i=a;i<a+3;i++ ){
            for(int j=b; j<b+3; j++){

                if(mat[i][j]!='.'){
                     if(set.contains(mat[i][j])){
                    return false;
                }
                set.add(mat[i][j]);
                }
               

            }


        }
        return true;
    }
}