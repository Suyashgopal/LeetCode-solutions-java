class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int row= mat.length;
        int c= mat[0].length;

        int l=0;
        int r=c-1;
        int up=0;
        int down= row-1;
       
        List<Integer> al= new ArrayList<>();
    

        while(l<=r && up <=down){
          //right

          for(int j=l;j<=r;j++){
         al.add(mat[up][j]);

          }
          up++;
        
          if(up>down){break;}
        



          //down 
          for(int i= up;i<= down ;i++){
           al.add(mat[i][r]);
          }
          r--;
          if(l>r){break;}

          //left
          for(int j=r;j>= l;j--){
            al.add(mat[down][j]);
          }          

        down--;
        if(up>down){break;}

        //up
        for(int i= down;i>= up; i--){
            al.add(mat[i][l]);
        }
        l++;
        if(l>r){break;}

     


                
        }

return al;
        
    }
}