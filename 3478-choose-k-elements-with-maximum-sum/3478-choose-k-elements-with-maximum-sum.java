class Solution {
    public long[] findMaxSum(int[] n1, int[] n2, int k) {
        int n= n1.length;
        //make matrix
        int[][] mat= new int[n][3];
        for(int i=0;i<n;i++){
            mat[i][0]= n1[i];
            mat[i][1]= n2[i];
            mat[i][2]= i;

        }
        //sort the matrix
        Arrays.sort(mat, (a, b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minheap= new PriorityQueue<>();
        long [] res= new long[n];
        long sum=0;
        int i=0;
        int resptr=0;
        while(i<n){
            int j=i;
            while(j<n && mat[j][0]== mat[i][0]){
                 resptr= mat[j][2];
                res[resptr]= sum; 
                j++; 
            }
             for(int p=i;p<j;p++){
                minheap.offer(mat[p][1]);
            sum= sum+mat[p][1];   

             }
          
            while(minheap.size()>k){
                sum= sum- minheap.poll();
            }
   i=j;
        }

        
         return res;
    }
}