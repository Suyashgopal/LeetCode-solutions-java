class Solution {
    public int[][] kClosest(int[][] arr, int k) {
        int n= arr.length;
        PriorityQueue<double[]> pq= new PriorityQueue<>((a,b)->Double.compare(a[2],b[2]));
        //fill the elements
        for(int i=0;i<n;i++){
            double x=(double) arr[i][0];
            double y=(double) arr[i][1];
            double dist= x*x + y*y;
            dist= Math.sqrt(dist);
            pq.add(new double []{x,y, dist});
        }
        int [][] res= new int[k][2];
        for(int i=0;i<k;i++){
            double [] curr= pq.poll();
            res[i][0]= (int)curr[0];
            res[i][1]= (int) curr[1];
        }


        return res;


        
    }
}