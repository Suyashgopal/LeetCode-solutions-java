class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat= new int[n][n];

        int row= n;
        int c= n;

        int l=0;
        int r=c-1;
        int up=0;
        int down= row-1;
        int count=1;
       
    

        while(l<=r && up <=down){
          //right

          for(int j=l;j<=r;j++){
         mat[up][j]= count;
         count++;

          }
          up++;
        
          if(up>down){break;}
        



          //down 
          for(int i= up;i<= down ;i++){
           mat[i][r]= count;
           count++;
          }
          r--;
          if(l>r){break;}

          //left
          for(int j=r;j>= l;j--){
            mat[down][j] = count;
            count++;
          }          

        down--;
        if(up>down){break;}

        //up
        for(int i= down;i>= up; i--){
        mat[i][l]= count;
        count++;
        }
        l++;
        if(l>r){break;}

     


                
        }

return mat;
        
    













        
    }
}